package com.dgaznares.mscurso.producto.infraestructure.adapters.out.persistence;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.dgaznares.mscurso.producto.domine.model.Product;
import com.dgaznares.mscurso.producto.domine.ports.out.ProductRepositoryPort;
import com.dgaznares.mscurso.producto.infraestructure.adapters.out.persistence.mappers.ProductEntityToProductConverter;


@Repository
public class ProductPersistenceAdapter implements ProductRepositoryPort{

	private final ProductRepository productRepository;
	private final ProductEntityToProductConverter productEntityToProductConverter;
	
	public ProductPersistenceAdapter(ProductRepository productRepository,
							  ProductEntityToProductConverter productEntityToProductConverter){
		
		this.productRepository=productRepository;
		this.productEntityToProductConverter=productEntityToProductConverter;
	}

	@Override
	public List<Product> findAll() {
		return productRepository.findAll().stream()
				.map(productEntityToProductConverter::convert)
				.toList();
	}

	@Override
	public List<Product> findProductsMoreExpensiveThan(BigDecimal price) {
		
		return productRepository.findByPrecioGreaterThan(price)
				.stream()
				.map(productEntityToProductConverter::convert)
				.toList();
	}

	@Override
	public List<Product> findProductsCheaperThanThan(BigDecimal price) {
		return productRepository.findByPrecioLessThan(price)
				.stream()
				.map(productEntityToProductConverter::convert)
				.toList();
	}

}