package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Participant;


@Repository
public interface ParticipantRepository extends JpaSpecificationExecutor<Participant>, JpaRepository<Participant, Long> {

	@Query(value = "SELECT p.* FROM participant p join event e on e.id = p.event_id WHERE JSON_EXTRACT(e.location, '$.country') = :country", nativeQuery = true )
	public List<Participant> getParticipantByEventLocation(@Param("country") String country);
}
