package com.dgaznares.mscurso.producto.infraestructure.adapters.in.web.dtos;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
	private Integer id;
	private String nombre;
	private BigDecimal precio;
	private String categoria;
	

}
