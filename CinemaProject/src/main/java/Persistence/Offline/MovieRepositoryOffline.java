package Persistence.Offline;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import Persistence.Entities.Movie;
import Persistence.Offline.database.OfflineDB;
import Persistence.Repositories.interfaces.MovieRepository;
import Persistence.webentities.CurrentMovie;

@Stateless
@Default
public class MovieRepositoryOffline implements MovieRepository{
	
	@Inject
	private OfflineDB db;
	
	public MovieRepositoryOffline(){};
	
	@Override
	public List<Movie> getMovies(){
		return db.getMovies();
	}

	@Override
	public CurrentMovie getCurrentMovieFromId(int movieId) {
		return db.getCurrentMovie(movieId);
	}

}
