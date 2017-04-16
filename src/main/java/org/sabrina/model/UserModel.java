package org.sabrina.model;

import java.util.List;
import java.util.Set;

import javax.persistence.*;
import org.hibernate.validator.constraints.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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
	private String password;
	@Column(name="username")
	private String username;
	
	@ElementCollection (fetch = FetchType.EAGER)
	private List<GrantedAuthority> roles;
	
	
	//siempre se añade un constructor vacio
	public UserModel(String username, String password, String email, List<GrantedAuthority> roles){
		this.username = username;
		this.email=email;
		this.password = new BCryptPasswordEncoder().encode(password);
		this.roles=roles;
	}
	
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


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public List<GrantedAuthority> getRoles() {
		return roles;
	}


	public void setRoles(List<GrantedAuthority> roles) {
		this.roles = roles;
	}
}
