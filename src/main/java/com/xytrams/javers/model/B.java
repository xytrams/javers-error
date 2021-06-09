package com.xytrams.javers.model;

import java.util.Set;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class B {
	
	@Id
	private final String id;
	private final String name;
	private final int age;
	private final Set<E> profiles;
}
