package com.example.inventaire.repository;

import com.example.inventaire.entity.Sample;
import com.example.inventaire.entity.SampleLine;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SampleLineRepository  extends Neo4jRepository<SampleLine,Long> {
    @Query("MATCH (sampleline:SampleLine) MATCH (sample:Sample)-[SAMPLE_LINE]-(sampleline)" +
            " WHERE ID(sample) = $sample.__id__ RETURN sampleline")
    List<SampleLine> findBySample(@Param("sample") Sample sample);


}
