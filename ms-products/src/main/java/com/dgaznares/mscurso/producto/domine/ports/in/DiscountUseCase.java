package com.dgaznares.mscurso.producto.domine.ports.in;

import java.math.BigDecimal;
import java.util.List;

import com.dgaznares.mscurso.producto.domine.model.Product;

public interface DiscountUseCase {
	
	public List<Product> getProductsWithDiscount(BigDecimal discount);

}
