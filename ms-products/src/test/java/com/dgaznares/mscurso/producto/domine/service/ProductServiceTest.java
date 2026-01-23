package com.dgaznares.mscurso.producto.domine.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.Predicate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dgaznares.mscurso.producto.domine.model.Category;
import com.dgaznares.mscurso.producto.domine.model.CategoryAnalysis;
import com.dgaznares.mscurso.producto.domine.model.Product;
import com.dgaznares.mscurso.producto.domine.ports.out.ProductRepositoryPort;

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
	
	@Test
	void analisysTest() {
		//GIVEN
		BigDecimal techAverageExpected = new BigDecimal("433.50");
		
		List<Product> listOfProducts = List.of(
				Product.builder().categoria(Category.TECH.name()).id(1).nombre("Laptop Gaming").precio(new BigDecimal("1200.5")).build(),
				Product.builder().categoria(Category.TECH.name()).id(2).nombre("Mouse").precio(new BigDecimal("20.00")).build(),
				Product.builder().categoria(Category.TECH.name()).id(3).nombre("Teclado").precio(new BigDecimal("80.00")).build(),
				Product.builder().categoria(Category.HOME.name()).id(4).nombre("Lámpara").precio(new BigDecimal("2.00")).build());
		when(productRepositoryPort.findAll()).thenReturn(listOfProducts);
		//WHEN
		List<CategoryAnalysis> result = productService.analisys();
		//THEN
		assertEquals(2, result.size());
		
		//TECH Assertion
		Predicate<CategoryAnalysis> siTechCategory = c -> Category.TECH == c.category();
		
		CategoryAnalysis techCategoryAnalisis = result.stream()
		.filter(siTechCategory)
		.findFirst()
		.orElseThrow();
		
		assertEquals(0, techAverageExpected.compareTo(techCategoryAnalisis.averagePrice()));
		assertEquals("Laptop Gaming", techCategoryAnalisis.starProduct().nombre());
		assertEquals(2, techCategoryAnalisis.cheaperThanAverageNames().size());
		assertTrue(techCategoryAnalisis.cheaperThanAverageNames().containsAll(List.of("Mouse", "Teclado")));
	}
}
