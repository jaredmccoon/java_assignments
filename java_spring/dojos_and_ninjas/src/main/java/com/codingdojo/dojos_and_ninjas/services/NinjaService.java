package com.codingdojo.dojos_and_ninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.dojos_and_ninjas.models.Ninja;
import com.codingdojo.dojos_and_ninjas.repositories.NinjaRepo;

@Service
public class NinjaService {
	@Autowired
	private NinjaRepo ninjaRepo;
	
//	READ ALL
	public List<Ninja> allNinjas(){
		return ninjaRepo.findAll();
	}
	
//	CREATE
	public Ninja createNinja(Ninja n) {
		return ninjaRepo.save(n);
	}
	
//	READ ONE
	public Ninja findNinja(Long id) {
		Optional<Ninja> optionalNinja = ninjaRepo.findById(id);
		if(optionalNinja.isPresent()) {
			return optionalNinja.get();
		} else {
			return null;
		}
	}
	
//	UPDATE
	public Ninja updateNinja(Ninja n) {
		return ninjaRepo.save(n);
	}
	
//	DELETE
	public void deleteNinja (Long id) {
		ninjaRepo.deleteById(id);
	}
}

