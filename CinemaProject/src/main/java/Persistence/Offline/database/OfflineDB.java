package Persistence.Offline.database;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

import Persistence.Entities.Movie;
import Persistence.Entities.User;
@Singleton
public class OfflineDB {
	
	private List<Movie> movies;
	private List<User> users;
	
	public OfflineDB(){
		
	}

	@PostConstruct
	public void setupData(){
		setupMovies();
		setupUsers();
	}

	private void setupMovies() {
		movies = new ArrayList<Movie>();
		movies.add(new Movie(1, "Bugs Life", false));
		movies.add(new Movie(2, "Star Wars", false));
	}
	
	private void setupUsers(){
		users = new ArrayList<User>();
		users.add(new User(1, "password", "Edward", "Smith", "e.smith@email.com"));
	}

	public List<Movie> getMovies() {
		return new ArrayList<Movie>(movies);
		
	}

	public User login(String emailAddress, String password) {
		for (User user : users)
		{
			if (user.getEmailAddress().equals(emailAddress) && user.getPassword().equals(password))
			{
				return user;
			}
		}
		return null;
	}
}	
