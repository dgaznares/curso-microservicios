package com.dgaznares.mscurso.producto.infraestructure.adapters.in.web;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import com.dgaznares.mscurso.producto.domine.model.Category;
import com.dgaznares.mscurso.producto.domine.model.CategoryAnalysis;
import com.dgaznares.mscurso.producto.domine.model.Product;
import com.dgaznares.mscurso.producto.domine.ports.in.AnalysisUseCase;
import com.dgaznares.mscurso.producto.domine.ports.in.DiscountUseCase;
import com.dgaznares.mscurso.producto.domine.ports.in.PricesUseCase;
import com.dgaznares.mscurso.producto.infraestructure.adapters.in.web.dtos.CategoryAnalysisDTO;
import com.dgaznares.mscurso.producto.infraestructure.adapters.in.web.dtos.ProductDTO;
import com.dgaznares.mscurso.producto.infraestructure.adapters.in.web.mappers.CategoryAnalysisToCategoryAnalysisDTOConverter;
import com.dgaznares.mscurso.producto.infraestructure.adapters.in.web.mappers.ProductToProductDTOConverter;

import lombok.extern.slf4j.Slf4j;

@WebMvcTest (ProductController.class)
@Slf4j
class ProductControllerTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@MockitoBean
	DiscountUseCase discountUseCase;
	
	@MockitoBean
	PricesUseCase pricesUseCase;
	
	@MockitoBean
	AnalysisUseCase analysisUseCase;
	
	@MockitoBean
	ProductToProductDTOConverter productToProductDTOConverter;
	
	@MockitoBean
	CategoryAnalysisToCategoryAnalysisDTOConverter categoryAnalysisToCategoryAnalysisDTOConverter;
	

	@Test
	void listarProductosConDescuento() throws Exception {
		
		//Given
		BigDecimal discount = new BigDecimal("0.5");
		Product product = new Product(1, "Laptop", new BigDecimal("50.0") , "ELECTRONICA");
		List<Product> listaProductos = List.of(product);
				
		ProductDTO productDTO = ProductDTO.builder()
				.id(1)
				.categoria("ELECTRONICA")
				.nombre("Laptop")
				.precio(new BigDecimal("50.0"))
				.build();
		when(productToProductDTOConverter.convert(product)).thenReturn(productDTO);
		when(discountUseCase.getProductsWithDiscount(discount)).thenReturn(listaProductos);
		
		
		//When & Then
		mockMvc.perform(get("/api/products/0.5").contentType(MediaType.APPLICATION_JSON))
						.andExpect(status().isOk())
						.andExpect(jsonPath("$[0].nombre").value("Laptop"))
						.andExpect(jsonPath("$[0].precio").value("50.0"));
	}
	
	@Test
	void analisisTest() throws Exception{
		//GIVEN
		Product starProduct = Product.builder().categoria(Category.TECH.name()).id(1).nombre("Laptop Gaming").precio(new BigDecimal("1200.50")).build();
		List<String> cheaperThanAverage  = List.of("Mouse", "Teclado");
		CategoryAnalysis categoryAnalysisTech = CategoryAnalysis.builder()
				.averagePrice(new BigDecimal("433.50"))
				.category(Category.TECH)
				.starProduct(starProduct)
				.cheaperThanAverageNames(cheaperThanAverage)
				.build();
		List<CategoryAnalysis> categoryAnalisisList = List.of(categoryAnalysisTech);
			
		CategoryAnalysisDTO categoryAnalysisDTO = CategoryAnalysisDTO.builder()
				.averagePrice(new BigDecimal("433.50"))
				.category(Category.TECH)
				.starProduct(starProduct)
				.cheaperThanAverageNames(cheaperThanAverage)
				.build();
		//List<CategoryAnalysisDTO> categoryAnalisisDTOList = List.of(categoryAnalysisDTO);
		
		when(analysisUseCase.analisys()).thenReturn(categoryAnalisisList);
		when(categoryAnalysisToCategoryAnalysisDTOConverter.convert(categoryAnalysisTech)).thenReturn(categoryAnalysisDTO);
		//WHEN //THEN 
		mockMvc
			.perform(get("/api/products/analysis")
					.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$[0].category").value(Category.TECH.name()))
		.andExpect(jsonPath("$[0].averagePrice").value(new BigDecimal("433.5")));
		log.info("Prueba terminada. Comprobacion PR");
	}
	

}
