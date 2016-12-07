package Persistence.Repositories.interfaces;

import java.util.List;

import Persistence.Entities.Movie;
import Persistence.webentities.CurrentMovie;

public interface MovieRepository {
	public List<Movie> getMovies();
	public CurrentMovie getCurrentMovieFromId(int movieId);
}
