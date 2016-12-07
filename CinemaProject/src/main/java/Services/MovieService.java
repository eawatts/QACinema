package Services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import Persistence.Entities.Movie;
import Persistence.Repositories.interfaces.MovieRepository;
import Persistence.webentities.CurrentMovie;

@Stateless
public class MovieService {

	@Inject
	private MovieRepository movieRepository;

	public List<Movie> getAllMovies(){
		return movieRepository.getMovies();
	}

	public List<Movie> getActiveMovies() {
		ArrayList<Movie> activeMovies = new ArrayList<Movie>();
		for(Movie movie : getAllMovies()){
			if(movie.isDiscontinued()==true){
				continue;
			}
			else{
				activeMovies.add(movie);
			}
		}		
		return activeMovies;
	}

	public CurrentMovie getCurrentMovieFromId(int movieId) {
		return movieRepository.getCurrentMovieFromId(movieId);
	}
}
