package com.dgaznares.mscurso.producto.domine.model;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.With;

@Builder
@With
public record Product(Integer id, 
		String nombre, 
		BigDecimal precio, 
		String categoria) {}
