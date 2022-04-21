package com.codingdojo.save_travel.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="expenses")
public class Expense {
    // -------------------variables-------------------
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message="Can not be null or blanks.")
	@Size(min=3, max=200, message="Expense must be more than 3 characters.")
	private String expenseName;
	
	@NotBlank(message="Can not be null or blanks.")
	@Size(min=3, max=200, message="Vendor must be more than 3 characters.")
	private String vendor;
	
	@NotNull(message="Can not be null.")
	@Positive(message="Must be more than a penny.")
	private Integer charge;
	
	@NotNull
	@Size(min=5, max=1000, message="Description should be more than 5 characters")
	private String description;
	
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;

    // -------------------constructors (include an empty one)-------------------
    public Expense() {}

    // -------------------methods-------------------
    // These tie to the mandatory variables above:
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }


    // -------------------getters & setters-------------------
    public Long getId() {
    	return id;
    }
    public void setId(Long id) {
    	this.id = id;
    }
    
    public String getExpenseName() {
    	return expenseName;
    }
    public void setExpenseName(String expense) {
    	this.expenseName = expense;
    }
    
    public String getVendor() {
    	return vendor;
    }
    public void setVendor(String vendor) {
    	this.vendor = vendor;
    }
    
    public Integer getCharge() {
    	return charge;
    }
    public void setCharge(Integer charge) {
    	this.charge = charge;
    }
    
    public String getDescription() {
    	return description;
    }
    public void setDescription(String description) {
    	this.description = description;
    }
    
    public Date getCreatedAt() {
    	return createdAt;
    }
    public void setCreatedAt(Date createdAt) {
    	this.createdAt = createdAt;
    }
    
    public Date getUpdatedAt() {
    	return updatedAt;
    }
    public void setUpdatedAt(Date updatedAt) {
    	this.updatedAt = updatedAt;
    }

}