package com.codingdojo.book_club2.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {
// user id
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
// username
	@NotEmpty(message="Username is required")
	@Size(min=3, max=30, message="Username must be between 3 and 30 characters")
	private String userName;
// email
	@NotEmpty(message="email is required")
	@Email(message="Enter a valid email")
	private String email;
// password
	@NotEmpty(message="Password is required")
	@Size(min=8, max=64, message="Password must be between 8 and 64 charachters")
	private String password;
// books
	   @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	   private List<Book> books;
// confirm password

	@Transient
	@NotEmpty(message="Confirm Password is required!")
	@Size(min=8, max=64, message="Confirm Password must be between 8 and 64 characters")
	private String confirm;

// created_at updated_at
// constructor
	public User() {}
	// getters and setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
}
	
