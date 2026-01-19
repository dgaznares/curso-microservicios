package com.example.producto.domine.ports.out;

import java.math.BigDecimal;
import java.util.List;

import com.example.producto.domine.model.Product;

public interface ProductRepositoryPort {
	
	public List<Product> findAll();
	public List<Product> findProductsMoreExpensiveThan(BigDecimal price);
	public List<Product> findProductsCheaperThanThan(BigDecimal price);
	

}
