package com.dgaznares.mscurso.producto.domine.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.dgaznares.mscurso.producto.domine.model.Category;
import com.dgaznares.mscurso.producto.domine.model.CategoryAnalysis;
import com.dgaznares.mscurso.producto.domine.model.Product;
import com.dgaznares.mscurso.producto.domine.ports.in.AnalysisUseCase;
import com.dgaznares.mscurso.producto.domine.ports.in.DiscountUseCase;
import com.dgaznares.mscurso.producto.domine.ports.in.PricesUseCase;
import com.dgaznares.mscurso.producto.domine.ports.out.ProductRepositoryPort;

@Service
public class ProductService implements DiscountUseCase, PricesUseCase, AnalysisUseCase{
	
	private final ProductRepositoryPort productRepositoryPort;
	
	public ProductService(ProductRepositoryPort productRepositoryPort){
		this.productRepositoryPort=productRepositoryPort;
	}

	
	private Product applyDiscount(Product p, BigDecimal discount) {
	    BigDecimal nuevoPrecio = p.precio().multiply(discount);
	    // Como Product es un record, creamos uno nuevo con el precio modificado
	    return new Product(p.id(), p.nombre(), nuevoPrecio, p.categoria());
	}
	@Override
	public List<Product> getProductsWithDiscount(BigDecimal discount) {
		
		return productRepositoryPort.findAll()
					.stream()
					.map(producto -> applyDiscount(producto, discount))
					.toList();
	}

	@Override
	public List<Product> findProductsMoreExpensiveThan(BigDecimal price) {
		return productRepositoryPort.findProductsMoreExpensiveThan(price); 
	}

	@Override
	public List<Product> findProductsCheaperThanThan(BigDecimal price) {
		return productRepositoryPort.findProductsCheaperThanThan(price); 
	}

	
	private CategoryAnalysis createAnalisis(String category, List<Product> productList) {
		
		BigDecimal average = productList.stream()
				.map(Product::precio)
				.reduce(BigDecimal.ZERO, BigDecimal::add)
				.divide(
						BigDecimal.valueOf(productList.size()),
						2,
						RoundingMode.HALF_UP
					);
	 
		Product startProduct = productList.stream()
				.max(Comparator.comparing(Product::precio))
				.orElseThrow();
		
		List<String> cheaperThanAverageNames = productList.stream()
				.filter(p -> (p.precio().compareTo(average) < 0))
				.map(Product::nombre)
				.toList();
		
		
		return CategoryAnalysis.builder()
				.category(Category.fromString(category)
						.orElseThrow(() -> new IllegalArgumentException("Category Must exist")
						))
						.averagePrice(average)
				.starProduct(startProduct)
				.cheaperThanAverageNames(cheaperThanAverageNames)
				.build();
	
	}

	@Override
	public List<CategoryAnalysis> analisys() {
		
		Map<String, List<Product>>  listProductByCategory =  productRepositoryPort.findAll()
		.stream()
		.collect(Collectors.groupingBy(
				Product::categoria
				));
		
		return listProductByCategory.entrySet()
				.stream()
				.map(category -> createAnalisis(category.getKey(), category.getValue()))
				.toList();
	}

	
	
	
}
