package com.codingninjas.EVotingSystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingninjas.EVotingSystem.entities.Election;
import com.codingninjas.EVotingSystem.entities.ElectionChoice;
import com.codingninjas.EVotingSystem.entities.User;
import com.codingninjas.EVotingSystem.entities.Vote;
import com.codingninjas.EVotingSystem.repositories.ElectionChoiceRepository;
import com.codingninjas.EVotingSystem.repositories.ElectionRepository;
import com.codingninjas.EVotingSystem.repositories.UserRepository;
import com.codingninjas.EVotingSystem.repositories.VoteRepository;

@Service
public class MainService {
	
	@Autowired
	ElectionRepository electionRepo;
	
	@Autowired
	ElectionChoiceRepository electionChoiceRepo;
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	VoteRepository voteRepo;

	public List<Election> getAllElections() {
		return electionRepo.findAll();
	}

	public void addElection(Election election) {
		electionRepo.save(election);
	}

	public void addElectionChoice(ElectionChoice electionChoice) {
		Election election = electionRepo.findByName(electionChoice.getElection().getName());
		electionChoice.setElection(election);
		electionChoiceRepo.save(electionChoice);
	}

	public List<ElectionChoice> getAllElectionChoices() {
		return electionChoiceRepo.findAll();
	}

	public List<ElectionChoice> getElectionChoicesByElection(Election election) {
		return electionChoiceRepo.findAllByElection(election);
	}

	public void addUser(User user) {
		userRepo.save(user);
	}

	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

	public List<Vote> getAllVotes() {
		return voteRepo.findAll();
	}

	public void addVote(Vote vote) {
		User user = userRepo.findByName(vote.getUser().getName());
		Election election = electionRepo.findByName(vote.getElection().getName());
		ElectionChoice electionChoice = electionChoiceRepo.findByNameAndElection(vote.getElectionChoice().getName(), election);
		vote.setElection(election);
		vote.setUser(user);
		vote.setElectionChoice(electionChoice);
		voteRepo.save(vote);
	}

	public long countVotes() {
		return voteRepo.count();
	}

	public long countVotesByElection(Election election) {
		return voteRepo.countByElection(election);
	}

	public ElectionChoice winnerOfElection(Election election) {
		Election election1 = electionRepo.findByName(election.getName());
		return electionChoiceRepo.getWinner(election1.getId());
	}

}