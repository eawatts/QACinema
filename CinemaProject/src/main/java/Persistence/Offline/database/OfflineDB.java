package Persistence.Offline.database;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

import Persistence.Entities.Movie;
import Persistence.Entities.Review;
import Persistence.Entities.Showing;
import Persistence.Entities.User;
import Persistence.webentities.CurrentMovie;
@Singleton
public class OfflineDB {

	private List<Movie> movies;
	private List<User> users;
	private List<Review> reviews;
	private List<Showing> showings;

	public OfflineDB(){

	}

	@PostConstruct
	public void setupData(){
		setupMovies();
		setupUsers();
		setupReviews();
		setupShowings();
	}

	private void setupMovies() {
		movies = new ArrayList<Movie>();
		movies.add(new Movie(1, "Bugs Life", "Flik (Dave Foley) is an inventive ant who's "
				+ "always messing things up for his colony. His latest mishap was destroying "
				+ "the food stores that were supposed to be used to pay off grasshopper Hopper "
				+ "(Kevin Spacey). Now the strong-arming insect is demanding that the ants gather "
				+ "double the food -- or face annihilation. To avert disaster, Flik goes on a journey"
				+ " to recruit fighters to defend the colony. When he meets a band of high-flying "
				+ "circus insects, he thinks he's found his salvation.",
				false, "/images/movie_poster/abl_p.jpg",  "/images/bugs_life_banner_fit.jpg",
				"https://www.youtube.com/embed/Ljk2YJ53_WI", 1));
		movies.add(new Movie(2, "Star Wars:The Force Awakens", 
				"Thirty years after the defeat of the Galactic Empire, Han Solo (Harrison Ford)"
						+ " and his young allies face a new threat from the evil Kylo Ren (Adam Driver) "
						+ "and the First Order.",false, "/images/movie_poster/sw_p.jpg",
						"/images/star_wars_banner_fit.jpg", "https://www.youtube.com/embed/sGbxmsDFVnE", 3));
		movies.add(new Movie(3, "Step up","Tyler Gage (channing tatum) is from the wrong side of the"
				+ " tracks, caught up in a world of drugs,violence and crime. After leaving a party "
				+ "Tyler and his two friends end up outside the Maryland school of the arts they break"
				+ " in and find themselves in the theater where they destroy the set.", true,
				"/images/movie_poster/su_p.jpg",  "/images/star_wars_banner_fit.jpg", "https://www.youtube.com/embed/ZgnmCqA25-o", 2));
		movies.add(new Movie(4, "The Dark Knight Rises","It has been eight years since Batman (Christian Bale), "
				+ "in collusion with Commissioner Gordon (Gary Oldman), vanished into the night. Assuming "
				+ "responsibility for the death of Harvey Dent, Batman sacrificed everything for what he "
				+ "and Gordon hoped would be the greater good. However, the arrival of a cunning cat burglar"
				+ " (Anne Hathaway) and a merciless terrorist named Bane (Tom Hardy) force Batman out of exile"
				+ " and into a battle he may not be able to win.", false, "/images/movie_poster/bm_p.jpg", 
				"/images/batman_banner_fit.jpg", "https://www.youtube.com/embed/g8evyE9TuYk", 4));
	}

	private void setupUsers(){
		users = new ArrayList<User>();
		users.add(new User(1, "password", "Edward", "Smith", "e.smith@email.com"));
	}

	private void setupReviews(){
		reviews = new ArrayList<Review>();
		reviews.add(new Review(1, 0.2f, "rubbish", users.get(0), movies.get(0)));
	}

	public void setupShowings(){
		showings = new ArrayList<Showing>();
		showings.add(new Showing(1, "Monday", new ArrayList<String>(Arrays.asList("09:00", "10:00"))));
		showings.add(new Showing(2, "Tuesday", new ArrayList<String>(Arrays.asList("09:00", "10:00", "11:00"))));
		showings.add(new Showing(3, "Wednesday", new ArrayList<String>(Arrays.asList("09:00", "10:00","11:00", "12:00"))));
		showings.add(new Showing(4, "Thursday", new ArrayList<String>(Arrays.asList("09:00", "10:00","11:00", "12:00","13:00"))));
		showings.add(new Showing(5, "Friday", new ArrayList<String>(Arrays.asList("09:00", "10:00","11:00", "12:00","13:00", "14:00"))));
		showings.add(new Showing(6, "Saturday", new ArrayList<String>(Arrays.asList("09:00", "10:00","11:00", "12:00","13:00", "14:00","15:00"))));
		showings.add(new Showing(7, "Sunday", new ArrayList<String>(Arrays.asList("09:00", "10:00","11:00", "12:00","13:00", "14:00","15:00","16:00"))));
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
		List<Showing> showings = this.showings;
		return new CurrentMovie(movie, averageReview, reviews, showings);
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
