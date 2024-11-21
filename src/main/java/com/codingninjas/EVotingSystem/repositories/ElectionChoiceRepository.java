package com.codingninjas.EVotingSystem.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.codingninjas.EVotingSystem.entities.Election;
import com.codingninjas.EVotingSystem.entities.ElectionChoice;

public interface ElectionChoiceRepository extends JpaRepository<ElectionChoice, Long> {

	public List<ElectionChoice> findAllByElection(Election election);
	
//	@Query("SELECT e FROM ElectionChoice e WHERE e.election = ?1 ORDER BY e.voteCount DESC")
	@Query(value = "SELECT ec.* FROM election_choice ec "
			+ "JOIN vote v ON ec.id = v.election_choice_id "
			+ "WHERE ec.election_id = ?1 "
			+ "GROUP BY ec.id "
			+ "ORDER BY COUNT(v.id) DESC LIMIT 1", nativeQuery = true)
	public ElectionChoice getWinner(long election);

	public ElectionChoice findByNameAndElection(String name, Election election);
	
}
