package Persistence.Repositories.interfaces;

import Persistence.Entities.User;

public interface LoginRepository {
	public User login(String emailAddress, String password);
}
