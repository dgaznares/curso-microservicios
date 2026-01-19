package com.example.producto.infraestructure.adapters.out.persistence.mappers;

import java.util.Optional;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.example.producto.domine.model.Product;
import com.example.producto.infraestructure.adapters.out.persistence.entities.ProductEntity;

@Component
public class ProductEntityToProductConverter implements Converter<ProductEntity, Product>{

	@Override
	public Product convert(ProductEntity source) {
		
		return Optional.ofNullable(source)
				.map(p -> Product.builder()
						.id(p.getId())
						.categoria(p.getCategoria())
						.nombre(p.getNombre())
						.precio(p.getPrecio())
						.build())
				.orElseThrow(() -> new NullPointerException("Objeto Nulo"));
		
	}
	

}
