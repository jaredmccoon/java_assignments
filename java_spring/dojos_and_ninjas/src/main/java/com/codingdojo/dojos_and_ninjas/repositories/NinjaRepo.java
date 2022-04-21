package com.codingdojo.dojos_and_ninjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.dojos_and_ninjas.models.Ninja;

@Repository
public interface NinjaRepo extends CrudRepository<Ninja, Long> {
	List<Ninja> findAll();
}
