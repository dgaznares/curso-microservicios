package com.example.producto.domine.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.producto.domine.model.Product;
import com.example.producto.domine.ports.in.DiscountUseCase;
import com.example.producto.domine.ports.in.PricesUseCase;
import com.example.producto.domine.ports.out.ProductRepositoryPort;

@Service
public class ProductService implements DiscountUseCase, PricesUseCase{
	
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

}
