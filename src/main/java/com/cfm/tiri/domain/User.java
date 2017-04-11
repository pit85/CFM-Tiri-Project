package com.cfm.tiri.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table( name="TIRI_USER" )
public class User {
	
	private Integer id;

	@Version
	private Integer version;
	@NotNull
	@Size(min=1 , max=50)
	private String firstName;
	@NotNull
	@Size(min=1 , max=100)
	private String lastName;
	private String login;
	private String password;
	@NotNull
	@Size(min=8 , max=20)
	private String mobilePhone;
	private String email;
	private Boolean active;
	private LocalDate creationDate;
	private Role role;
	
	public User(){
	}
	
	public User(Integer version, String firstName, String lastName, Role role,
			String password, String mobilePhone, String email, int idRole, Boolean active, LocalDate creationDate){
		
		this.version = version;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.mobilePhone = mobilePhone;
		this.email = email;
		this.active = active;
		this.role = role;
		this.creationDate = creationDate;
	}
	
	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}
	
    @Id
    @Column(name = "ID_USER")
    @GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login){
		this.login = firstName.toLowerCase().charAt(0) + lastName.toLowerCase();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = LocalDate.now();
	}

	@ManyToOne
    @JoinColumn(name = "ID_ROLE")
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}
