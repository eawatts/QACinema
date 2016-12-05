package Controllers;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import Persistence.Entities.User;
import Persistence.webentities.CurrentSession;
import Services.LoginService;

@Named("login")
@SessionScoped
public class LoginController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private CurrentSession currentsession;
	@Inject
	private LoginService loginservice;
	
	private String emailAddress = "";
	private String password = "";
	private String error;
	
	public String getEmailAddress(){
		return emailAddress;
	}
	
	public void setEmailAddress(String emailAddress){
		this.emailAddress = emailAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
	
	public String login(){
		if(emailAddress.equals("")){
			this.error = "Email Address required";
			this.password = "";
			return null;
		}
		else if(password.equals("")){
			this.error = "Password Required";
			this.password = "";
			return null;
		}
		User user = loginservice.Login(this.emailAddress, this.password);
		
		if(user == null){
			this.error = "Check Email or Password";
			this.password = null;
			return null;
		}
		
		currentsession.setUser(user);
		
		emailAddress = null;
		password = null;
		error = null;
		
		return "index";
	}
	
	public String logout(){
		this.emailAddress = null;
		this.password = null;
		this.error = null;
		currentsession.logout();
		return "index";
	}
	
}
