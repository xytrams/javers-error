package com.xytrams.javers;

import java.util.List;

import org.javers.core.Javers;
import org.javers.core.metamodel.object.CdoSnapshot;
import org.javers.repository.jql.QueryBuilder;
import org.springframework.stereotype.Service;

import com.lendico.kycservice.model.A;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AService {

	private final Javers javers;


	public String getInitSnapshot(String id) {
		QueryBuilder query = QueryBuilder.byClass(A.class);
		List<CdoSnapshot> snapshots = javers.findSnapshots(query.build());

		return javers.getJsonConverter().toJson(snapshots);
	}
}
