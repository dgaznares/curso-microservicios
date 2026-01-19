package com.example.producto.domine.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.producto.domine.model.Product;
import com.example.producto.domine.ports.out.ProductRepositoryPort;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

	@Mock
	ProductRepositoryPort productRepositoryPort;
	
	@InjectMocks
	ProductService productService;
	
	@Test
	void getProductsWithDiscountTest() {
		
		//Given
		BigDecimal discount = new BigDecimal("0.5");
		BigDecimal finalPrice = new BigDecimal("25.00");
		List<Product> listaProductos = List.of(
				new Product(1, "Laptop", new BigDecimal("50.0") , "ELECTRONICA")
				);
		when(productRepositoryPort.findAll())
			.thenReturn(listaProductos);
		//When
		List<Product> listResultado = productService.getProductsWithDiscount(discount);
		
		//Then
		assertEquals(1, listResultado.size());
		assertEquals(finalPrice, listResultado.get(0).precio());
		verify(productRepositoryPort, times(1)).findAll();
	}
}
