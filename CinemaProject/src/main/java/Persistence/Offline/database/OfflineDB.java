package Persistence.Offline.database;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

import Persistence.Entities.Movie;
@Singleton
public class OfflineDB {
	
	private List<Movie> movies;
	
	public OfflineDB(){
		
	}

	@PostConstruct
	public void setupData(){
		setupMovies();
	}

	private void setupMovies() {
		movies = new ArrayList<Movie>();
		movies.add(new Movie(1, "Bugs Life", false));
	}

	public List<Movie> getMovies() {
		return new ArrayList<Movie>(movies);
		
	}
}	
