package com.codingdojo.book_club2.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="books")
public class Book{
// book id
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
// title
	@NotNull
	@Size(min = 5, max = 200, message = "Title is required")
	private String title;
// author 
	@NotNull
	@Size(min = 5, max = 200, message = "Author is required")
	private String author;
// mythoughts
	@NotNull
	@Size(min = 5, max = 200, message = "Your thoughts are required")
	private String mythoughts;
// user
	@ManyToOne(fetch = FetchType.LAZY) 
	@JoinColumn(name = "user_id") 
	private User user; 
// created_at updated_at
	@Column(updatable = false)
	private Date createdAt;
	private Date updatedAt;
// constructor
	public Book() {}
	// getters and setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getMythoughts() {
		return mythoughts;
	}
	public void setMythoughts(String mythoughts) {
		this.mythoughts = mythoughts;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
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

	
