package Persistence.webentities;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import Persistence.Entities.Movie;
import Persistence.Entities.Review;
import Persistence.Entities.Showing;

@SessionScoped
@Named("current_movie")
public class CurrentMovie implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private MovieWithAverageReview movie;
	private List<Review> reviews;
	private List<Showing> showings;
	private int quantity = 1;
	
	public CurrentMovie(){}
	
	public CurrentMovie(Movie movie, Integer averageReview, List<Review> reviews, List<Showing> showings){
		this.movie = new MovieWithAverageReview(movie, averageReview);
		this.reviews = reviews;
		this.showings = showings;
	}
	
	public void setCurrentMovie(CurrentMovie currentMovie){
		this.movie = new MovieWithAverageReview(currentMovie.getMovie(), currentMovie.getAverageReview());
		this.reviews = currentMovie.getReviews();
		this.showings = currentMovie.getShowings();
	}
	
	public Movie getMovie(){
		return movie.getMovie();
	}
	
	public void setMovie(Movie movie){
		this.movie.setMovie(movie);
	}
	
	public Integer getAverageReview(){
		return movie.getAverageReview();
	}
	
	public List<Review> getReviews(){
		return reviews;
	}
	
	public void setReviews(List<Review> reviews){
		this.reviews = reviews;
	}
	
	public List<Showing> getShowings() {
		return showings;
	}

	public void setShowings(List<Showing> showings) {
		this.showings = showings;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	/**
	 * Get the count of the reviews for the Current Product.
	 * @return
	 */
	public int getReviewsCount(){
		if(reviews == null){
			return 0;
		}
		return reviews.size();
	}
	/**
	 * Get only the showings on the current day.
	 */
	public Showing getTodayShowing(){
		for(Showing time : getShowings()){
			if(time.getId() == Calendar.getInstance().get(Calendar.DAY_OF_WEEK)-1){
				return time;
			}
		}
		return null;
	}
}	