package com.example.producto.domine.ports.in;

import java.math.BigDecimal;
import java.util.List;

import com.example.producto.domine.model.Product;

public interface PricesUseCase {
	
	public List<Product> findProductsMoreExpensiveThan(BigDecimal price);
	public List<Product> findProductsCheaperThanThan(BigDecimal price);

}
