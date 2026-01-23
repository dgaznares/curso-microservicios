package com.dgaznares.mscurso.producto.domine.model;

import java.math.BigDecimal;
import java.util.List;

import lombok.Builder;

@Builder
public record CategoryAnalysis(
	    Category category,
	    BigDecimal averagePrice,
	    Product starProduct,
	    List<String> cheaperThanAverageNames
	) {}