package com.codingdojo.save_travel.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.save_travel.models.Expense;
import com.codingdojo.save_travel.repo.ExpenseRepo;



@Service
public class ExpenseService {
	@Autowired
	private ExpenseRepo expenseRepo;
	
	public List<Expense> allExpenses() {
        return expenseRepo.findAll();
    }
	
    // creates an expense
    public Expense createExpense(Expense e) {
        return expenseRepo.save(e);
    }
    // retrieves a book by id
    public Expense findExpense(Long id) {
        Optional<Expense> optionalExpense = expenseRepo.findById(id);
        if(optionalExpense.isPresent()) {
            return optionalExpense.get();
        } else {
            return null;
        }
    }
    // updates an expense
    public Expense updateExpense(Expense e) {
       	return expenseRepo.save(e);
    }
    
    // deletes an expense
    public void deleteExpense(Long id) {
    	expenseRepo.deleteById(id);
    }
}