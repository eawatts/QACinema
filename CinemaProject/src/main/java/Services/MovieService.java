package Services;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import Persistence.Entities.Movie;
import Persistence.Repositories.interfaces.MovieRepository;

@Stateless
public class MovieService {
	
	@Inject
	private MovieRepository movieRepository;
	
	public List<Movie> getAllMovies(){
		return movieRepository.getMovies();
	}
}
