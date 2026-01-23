package com.dgaznares.mscurso.producto.infraestructure.adapters.in.web;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dgaznares.mscurso.producto.domine.ports.in.AnalysisUseCase;
import com.dgaznares.mscurso.producto.domine.ports.in.DiscountUseCase;
import com.dgaznares.mscurso.producto.domine.ports.in.PricesUseCase;
import com.dgaznares.mscurso.producto.infraestructure.adapters.in.web.dtos.CategoryAnalysisDTO;
import com.dgaznares.mscurso.producto.infraestructure.adapters.in.web.dtos.ProductDTO;
import com.dgaznares.mscurso.producto.infraestructure.adapters.in.web.mappers.CategoryAnalysisToCategoryAnalysisDTOConverter;
import com.dgaznares.mscurso.producto.infraestructure.adapters.in.web.mappers.ProductToProductDTOConverter;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
	private final DiscountUseCase discountUseCase;
	private final PricesUseCase pricesUseCase; 
	private final AnalysisUseCase analysisUseCase;
	
	private final ProductToProductDTOConverter productToProductDTOConverter;
	private final CategoryAnalysisToCategoryAnalysisDTOConverter categoryAnalysisToCategoryAnalysisDTOConverter;
	 
	@GetMapping("/{descuento}")
	public ResponseEntity<List<ProductDTO>> listarProductosConDescuento(@PathVariable BigDecimal descuento) {
		List<ProductDTO> listaProductos = discountUseCase.getProductsWithDiscount(descuento)
				.stream()
				.map(productToProductDTOConverter::convert)
				.toList();
		return listaProductos.isEmpty()?
				ResponseEntity.noContent().build():
				ResponseEntity.ok(listaProductos);
	}
		
	@GetMapping("/expensive/{precio}")
	public ResponseEntity<List<ProductDTO>> listarProductosMasCarosDe(@PathVariable BigDecimal precio) {
		List<ProductDTO> listaProductos = pricesUseCase. findProductsMoreExpensiveThan(precio)
				.stream()
				.map(productToProductDTOConverter::convert)
				.toList();
		
		return listaProductos.isEmpty()?
				ResponseEntity.noContent().build():
				ResponseEntity.ok(listaProductos);
	}
	
	@GetMapping("/cheap/{precio}")
	public ResponseEntity<List<ProductDTO>> listarProductosMasBararosDe(@PathVariable BigDecimal precio) {
		List<ProductDTO> listaProductos = pricesUseCase.findProductsCheaperThanThan(precio)
				.stream()
				.map(productToProductDTOConverter::convert)
				.toList();
		return listaProductos.isEmpty()?
				ResponseEntity.noContent().build():
				ResponseEntity.ok(listaProductos);
	}
	
	

	@GetMapping("/analysis")
	public ResponseEntity<List<CategoryAnalysisDTO>> analysis(){
		List<CategoryAnalysisDTO> listaProductos = analysisUseCase.analisys()
				.stream()
				.map(categoryAnalysisToCategoryAnalysisDTOConverter::convert)
				.toList();
		return listaProductos.isEmpty()?
				ResponseEntity.noContent().build():
				ResponseEntity.ok(listaProductos);
	
	}
	
	
}