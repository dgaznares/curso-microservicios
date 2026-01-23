package com.dgaznares.mscurso.producto.infraestructure.adapters.in.web.mappers;

import java.util.Optional;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.dgaznares.mscurso.producto.domine.model.CategoryAnalysis;
import com.dgaznares.mscurso.producto.infraestructure.adapters.in.web.dtos.CategoryAnalysisDTO;

@Component
public class CategoryAnalysisToCategoryAnalysisDTOConverter implements Converter<CategoryAnalysis, CategoryAnalysisDTO>{

	@Override
	public CategoryAnalysisDTO convert(CategoryAnalysis source) {
		return Optional.ofNullable(source)
				.map(s -> CategoryAnalysisDTO.builder()
						.averagePrice(s.averagePrice())
						.category(s.category())
						.cheaperThanAverageNames(s.cheaperThanAverageNames())
						.starProduct(s.starProduct())
						.build())
				.orElseThrow();
	}

}
