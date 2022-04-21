package com.codingdojo.save_travel.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.save_travel.models.Expense;

public interface ExpenseRepo extends CrudRepository<Expense, Long>{
	List<Expense> findAll();
}
