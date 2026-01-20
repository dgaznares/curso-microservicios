package com.dgaznares.mscurso.producto.infraestructure.adapters.in.web.mappers;

import java.util.Optional;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.dgaznares.mscurso.producto.domine.model.Product;
import com.dgaznares.mscurso.producto.infraestructure.adapters.in.web.dtos.ProductDTO;

@Component
public class ProductToProductDTOConverter implements Converter<Product, ProductDTO>{

	@Override
	public ProductDTO convert(Product source) {
		
		return Optional.ofNullable(source)
				.map(p -> ProductDTO.builder()
						.id(p.id())
						.categoria(p.categoria())
						.nombre(p.nombre())
						.precio(p.precio())
						.build())
				.orElseThrow(() -> new NullPointerException("Objeto Nulo"));
		
	}
	

}
