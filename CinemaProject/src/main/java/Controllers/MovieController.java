package Controllers;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import Persistence.Entities.Movie;
import Services.MovieService;

@Named("movies")
@RequestScoped
public class MovieController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private MovieService movieService;
	
	public List<Movie> getMovies(){
		return movieService.getAllMovies();
	}
}
