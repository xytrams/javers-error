package com.xytrams.javers.model;

import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class F {
	private final Map<String, List<E>> map;
}
