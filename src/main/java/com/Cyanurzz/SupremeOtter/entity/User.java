package com.Cyanurzz.SupremeOtter.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull(message = "- Veuillez entrez prénom")
	@Size(min = 2, max = 30, message=" - Le prénom peut avoir entre 2 et 30 caractères maximum")
	@Pattern(regexp="^[-A-Za-z -]*$",message = "- Le prénom doit etre composé uniquement de lettres et peut contenir des espaces ou tirets")
	private String firstname;
	
	@NotNull(message = "- Veuillez entrez votre nom")
	@Size(min = 2, max = 30, message="- le nom peut avoir entre 2 et 30 caractères maximum")
	@Pattern(regexp="^[-A-Za-z -]*$",message ="- La nom doit etre composé uniquement de lettres et peut contenir des espaces ou tirets")
	private String lastname;
	
	@Pattern(regexp="^[a-zA-Z0-9_-]{3,30}$",message ="- Pseudo Invalide")
	private String username;
	
	@Pattern(regexp="[^@ \\t\\r\\n]+@[^@ \\t\\r\\n]+\\.[^@ \\t\\r\\n]+", message="- Email Invalide - Format demander : supremeotter@xxx.god")
	private String email;
	
	private String role;
	
	@NotNull(message ="Le mot de passe ne peut etre vide")
	@NotBlank(message ="Le mot de passe ne peut etre vide")
	private String password;
	
	private Date Birthday;
	
	
	@OneToMany(mappedBy="author")
	private List<Article> Articles;


	public User() {
		super();
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getBirthday() {
		return Birthday;
	}


	public void setBirthday(Date birthday) {
		Birthday = birthday;
	}


	public List<Article> getArticles() {
		return Articles;
	}

	public void setArticles(List<Article> articles) {
		Articles = articles;
	}
	
}
