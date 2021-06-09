package com.xytrams.javers;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.xytrams.javers.model.A;
import com.xytrams.javers.model.B;
import com.xytrams.javers.model.C;
import com.xytrams.javers.model.D;
import com.xytrams.javers.model.E;

import lombok.extern.slf4j.Slf4j;

@ActiveProfiles("test")
@SpringBootTest
@Slf4j
class AServiceTest {
	@Autowired
	private ARepository repository;
	
	@Autowired
	private AService service;

	
	@Test
	void testJavers() {
		repository.save(buildEntity());
		
		String info = service.getInitSnapshot("id");
		
		log.info(info);
		
		assertNotNull(info);
	}

	private A buildEntity() {
		Set<E> profiles = new HashSet<>();
		profiles.add(new E("p1", asList("teacher", "director")));
		profiles.add(new E("p2", asList("student", "pupil")));
		profiles.add(new E("p3", asList("manager", "director")));
				
		B b = new B("id", "name", 10, profiles);
		D d = new D("city", "country");
		C c =  new C("companyName", d);
		
		Map<String, List<E>> map = new HashMap<>();
		map.put("key1", asList(new E("p1", asList("teacher", "director")), new E("p3", asList("manager", "director"))));
		map.put("key2", asList(new E("p2", asList("student", "pupil"))));
		
		return new A(b, c, map);
	}
}
