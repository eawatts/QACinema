package Services;

import javax.ejb.Stateless;
import javax.inject.Inject;

import Persistence.Entities.User;
import Persistence.Repositories.interfaces.LoginRepository;

@Stateless
public class LoginService {
	
	@Inject
	private LoginRepository loginrepository;
	
	public User Login(String emailAddress, String password){
		return loginrepository.login(emailAddress, password);
	}
}
