package com.dgaznares.mscurso.producto.domine.model;

import java.util.Arrays;
import java.util.Optional;

public enum Category {
	TECH, HOME, FASHION;
	
	
	public static Optional<Category> fromString (String category) {		
		return Arrays.stream(Category.values())
		.filter(c ->  c.name().equalsIgnoreCase(category))
		.findFirst();
	}

}
