package org.sabrina.model;

import java.util.Set;

import javax.persistence.*;
import org.hibernate.validator.constraints.*;

@Entity
@Table(name="user")
public class UserModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="user_id")
	private int id;	
	@Column(name="email")
	@Email(message = "*Your email must be i.e: example@email.com*")
	@NotEmpty(message = "*Please provide an email*")
	private String email;	
	@Length(min=5, message="*Your password must have at least 5 characters*")
	@NotEmpty(message="*Please provide your password*")
	@Transient
	private String password;
	@Column(name="status")
	private int status;	
	@Column(name="name")
	@NotEmpty(message="*Please provide your name*")
	private String name;
	@Column(name="last_name")
	@NotEmpty(message="*Please provide your last name*")
	private String lastName;	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<RolModel> roles;
	
	
	//siempre se añade un constructor vacio
	public UserModel(){		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public Set<RolModel> getRoles() {
		return roles;
	}


	public void setRoles(Set<RolModel> roles) {
		this.roles = roles;
	}
}
