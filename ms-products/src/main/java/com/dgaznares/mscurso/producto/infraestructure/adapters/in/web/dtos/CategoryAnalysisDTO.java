package com.dgaznares.mscurso.producto.infraestructure.adapters.in.web.dtos;

import java.math.BigDecimal;
import java.util.List;

import com.dgaznares.mscurso.producto.domine.model.Category;
import com.dgaznares.mscurso.producto.domine.model.Product;

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
public class CategoryAnalysisDTO {
    private Category category;
    private BigDecimal averagePrice;
    private Product starProduct;
    private List<String> cheaperThanAverageNames;

}
