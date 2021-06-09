package com.xytrams.javers.model;

import java.util.List;
import java.util.Map;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Document(collection = "a_collection")
public class A {

	private final B b;
	private final C c;
	private final Map<String, List<E>> map;
//	private final F map;

}
