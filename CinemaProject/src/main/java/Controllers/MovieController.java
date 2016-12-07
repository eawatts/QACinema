package Controllers;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import Persistence.Entities.Movie;
import Persistence.webentities.CurrentMovie;
import Services.MovieService;

@Named("movies")
@RequestScoped
public class MovieController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private MovieService movieService;
	
	@Inject
	private CurrentMovie currentMovie;
	
	public String view(int movieId){
		currentMovie.setCurrentMovie(movieService.getCurrentMovieFromId(movieId));
		return "movie";
	}
	
	public List<Movie> getMovies(){
		return movieService.getAllMovies();
	}
	
	public List<Movie> getActiveMovies(){
		return movieService.getActiveMovies();
	}
}
