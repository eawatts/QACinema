package Persistence.Entities;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "User")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "id", nullable = false)
	private Integer id;
	
	@Column(name = "password", length = 256, nullable = false)
	@Size(min = 5, max = 45, message = "Password has to be between 5 and 45 in length.")
	private String password;

	@Column(name = "firstname", length = 50, nullable = false)
	@Size(min = 1, max = 45, message = "Firstname has to be between 1 and 45 in length.")
	private String firstname;

	@Column(name = "surname", length = 50, nullable = false)
	@Size(min = 1, max = 45, message = "Surname has to be between 1 and 45 in length.")
	private String surname;
	
	@Column(name = "email_address", nullable = false)
	private String emailAddress;
	
	public User(Integer id, String password, String firstname, String surname, String emailAddress){
		this();
		this.id=id;
		this.password=password;
		this.firstname = firstname;
		this.surname = surname;
		this.emailAddress= emailAddress;		
	}
	public User() {	}
	public Integer getId() {
		return id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
}
