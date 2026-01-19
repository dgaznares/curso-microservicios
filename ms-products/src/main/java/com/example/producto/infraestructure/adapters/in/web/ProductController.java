package com.example.producto.infraestructure.adapters.in.web;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.producto.domine.ports.in.DiscountUseCase;
import com.example.producto.domine.ports.in.PricesUseCase;
import com.example.producto.infraestructure.adapters.in.web.dtos.ProductDTO;
import com.example.producto.infraestructure.adapters.in.web.mappers.ProductToProductDTOConverter;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
	private final DiscountUseCase discountUseCase;
	private final PricesUseCase pricesUseCase; 
	private final ProductToProductDTOConverter productToProductDTOConverter;
	
	
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
	
}