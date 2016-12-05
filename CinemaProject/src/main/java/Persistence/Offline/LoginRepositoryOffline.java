package Persistence.Offline;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import Persistence.Entities.User;
import Persistence.Offline.database.OfflineDB;
import Persistence.Repositories.interfaces.LoginRepository;

@Stateless
@Default
public class LoginRepositoryOffline implements LoginRepository{
	
	@Inject
	private OfflineDB db;
	
	@Override
	public User login(String emailAddress, String password) {
		return db.login(emailAddress, password);
	}

}
