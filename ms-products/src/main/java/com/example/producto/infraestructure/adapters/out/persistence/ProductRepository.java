package com.example.producto.infraestructure.adapters.out.persistence;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.producto.infraestructure.adapters.out.persistence.entities.ProductEntity;


public interface ProductRepository extends JpaRepository<ProductEntity, Integer>{
	
	List<ProductEntity> findByPrecioGreaterThan(BigDecimal precio);
	List<ProductEntity> findByPrecioLessThan(BigDecimal precio);

}
