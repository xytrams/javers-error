package com.xytrams.javers;

import java.util.Optional;

import org.javers.spring.annotation.JaversSpringDataAuditable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.xytrams.javers.model.A;

@JaversSpringDataAuditable
public interface ARepository extends MongoRepository<A, String>{

    @Query(value = "{'b.id' : ?0 }")
	public Optional<A> findById(String id);
}

