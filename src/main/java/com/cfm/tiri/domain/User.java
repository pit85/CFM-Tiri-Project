package com.cfm.tiri.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "tiri_user")
public class User {

	private long id;
	private long version;
	@NotNull
	@Size(min = 1, max = 50)
	private String firstName;
	@NotNull
	@Size(min = 1, max = 100)
	private String lastName;
	private String login;
	private String password;
	@NotNull
	@Size(min = 8, max = 20)
	private String mobilePhone;
	private String email;
	@NotNull
	private boolean active;
	
	@Column(name = "creation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date  creationDate = new Date();
	private Role role;
	private List<Squad> squads;


	public User() {
	}

	public User(String firstName, String lastName, Role role, String password, String mobilePhone,
			String email, Boolean active) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.mobilePhone = mobilePhone;
		this.email = email;
		this.active = active;
		this.role = role;
	}

	@Version
	@Column(name = "version")
	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

	@Id
	@Column(name = "id_user")
	@GeneratedValue(strategy=GenerationType.AUTO, generator = "id_Sequence")
	@SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ" )
	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public void setLogin(String login) {
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

	public boolean getActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Date  getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date  creationDate) {
		this.creationDate = creationDate;
	}

	@ManyToOne
	@JoinColumn(name = "id_role")
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	public List<Squad> getSquads() {
		return squads;
	}

	public void setSquads(List<Squad> squads) {
		this.squads = squads;
	}

}
