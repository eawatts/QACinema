package Persistence.Offline.database;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

import Persistence.Entities.Movie;
import Persistence.Entities.Review;
import Persistence.Entities.User;
import Persistence.webentities.CurrentMovie;
@Singleton
public class OfflineDB {

	private List<Movie> movies;
	private List<User> users;
	private List<Review> reviews;

	public OfflineDB(){

	}

	@PostConstruct
	public void setupData(){
		setupMovies();
		setupUsers();
		setupReviews();
	}

	private void setupMovies() {
		movies = new ArrayList<Movie>();
		movies.add(new Movie(1, "Bugs Life", false));
		movies.add(new Movie(2, "Star Wars", false));
		movies.add(new Movie(3, "Step up", true));
		movies.add(new Movie(4, "Batman", false));
	}

	private void setupUsers(){
		users = new ArrayList<User>();
		users.add(new User(1, "password", "Edward", "Smith", "e.smith@email.com"));
	}
	
	private void setupReviews(){
		reviews = new ArrayList<Review>();
		reviews.add(new Review(1, 0.2f, "rubbish", users.get(0), movies.get(0)));
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

	public CurrentMovie getCurrentMovie(int movieId) {
		Movie movie = getMovieFromId(movieId);
		Integer averageReview = getAverageReviewForMovieId(movieId);
		List<Review> reviews = getReviewsForMovieId(movieId);
		return new CurrentMovie(movie, averageReview, reviews);
	}

	public Movie getMovieFromId(int movieId){
		for(Movie movie : movies){
			if(movie.getId() == movieId){
				return movie;
			}
		}
		return null;
	}
	
	public Integer getAverageReviewForMovieId(int movieId){
		Movie movie = getMovieFromId(movieId);
		if( movie == null){
			return null;
		}
		int reviewTotal = 0;
		int numberOfReviews = 0;

		for (Review review : reviews)
		{
			if (review.getMovie().getId() == movieId)
			{
				numberOfReviews++;
				reviewTotal += review.getRating();
			}
		}

		if (numberOfReviews == 0)
		{ // Also helps prevent divide by zero.
			return null;
		}

		return reviewTotal / numberOfReviews;
	}
	
	public List<Review> getReviewsForMovieId(int movieId){
		ArrayList<Review> reviewsForMovie = new ArrayList<Review>();
		for(Review review : reviews){
			if(review.getMovie().getId() == movieId){
				reviewsForMovie.add(review);
			}
		}
		return reviewsForMovie;
	}
}	
