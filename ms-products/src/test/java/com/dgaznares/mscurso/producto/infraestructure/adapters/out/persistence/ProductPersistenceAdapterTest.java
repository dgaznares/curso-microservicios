package com.dgaznares.mscurso.producto.infraestructure.adapters.out.persistence;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import com.dgaznares.mscurso.producto.domine.model.Product;
import com.dgaznares.mscurso.producto.infraestructure.adapters.out.persistence.entities.ProductEntity;
import com.dgaznares.mscurso.producto.infraestructure.adapters.out.persistence.mappers.ProductEntityToProductConverter;

import jakarta.persistence.EntityManager;

@DataJpaTest
@Import({
	ProductPersistenceAdapter.class, 
	ProductEntityToProductConverter.class
	})
class ProductPersistenceAdapterTest {

	@Autowired
	ProductPersistenceAdapter productPersistenceAdapter;
	
	@Autowired
	EntityManager entityManager; 
	
	@Test
	void findAll() {
		//GIVEN
		BigDecimal price = new BigDecimal("1200.5");
		entityManager.persist(new ProductEntity(null, "Test", new BigDecimal("1300.00"), "Electrónica"));		
		
		//WHEN
		List<Product>  productList = productPersistenceAdapter.findAll();
	    
	    // THEN: El precio debe ser exactamente el de la BD (100)
	    assertEquals(8, productList.size());
	    assertEquals(price, productList.get(0).precio());
	}

}
