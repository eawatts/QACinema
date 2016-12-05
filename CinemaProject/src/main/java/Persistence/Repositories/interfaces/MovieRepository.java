package Persistence.Repositories.interfaces;

import java.util.List;

import Persistence.Entities.Movie;

public interface MovieRepository {
	public List<Movie> getMovies();
}
