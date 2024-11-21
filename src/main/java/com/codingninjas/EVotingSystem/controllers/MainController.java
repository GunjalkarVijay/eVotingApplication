package com.codingninjas.EVotingSystem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.codingninjas.EVotingSystem.entities.Election;
import com.codingninjas.EVotingSystem.entities.ElectionChoice;
import com.codingninjas.EVotingSystem.entities.User;
import com.codingninjas.EVotingSystem.entities.Vote;
import com.codingninjas.EVotingSystem.services.MainService;

@RestController
public class MainController {

	@Autowired
	MainService service;
	
	@GetMapping("/get/elections")
	public List<Election> getAllElections(){
		return service.getAllElections();
	}
	
	@PostMapping("/add/election")
	public void addElection(@RequestBody Election election) {
		service.addElection(election);
	}
	
	@PostMapping("/add/electionChoice")
	public void addElectionChoice(@RequestBody ElectionChoice electionChoice) {
		service.addElectionChoice(electionChoice);
	}
	
	@GetMapping("/get/electionChoices")
	public List<ElectionChoice> getAllElectionChoices(){
		return service.getAllElectionChoices();
	}
	
	@PostMapping("/count/election/choices")
	public long getElectionChoicesByElection(@RequestBody Election election){
		return service.getElectionChoicesByElection(election).size();
	}
	
	@PostMapping("/add/user")
	public void addUser(@RequestBody User user) {
		service.addUser(user);
	}
	
	@GetMapping("/get/users")
	public List<User> getAllUsers(){
		return service.getAllUsers();
	}
	
	@GetMapping("/get/votes")
	public List<Vote> getAllVotes(){
		return service.getAllVotes();
	}
	
	@PostMapping("/add/vote")
	public void addVote(@RequestBody Vote vote) {
		service.addVote(vote);
	}
	
	@GetMapping("/count/votes")
	public long countVotes() {
		return service.countVotes();
	}
	
	@PostMapping("/count/election/votes")
	public long countVotesByElection(@RequestBody Election election) {
		return service.countVotesByElection(election);
	}
	
	@PostMapping("/winner/election")
	public ElectionChoice winnerOfElection(@RequestBody Election election) {
		return service.winnerOfElection(election);
	}
	
}
