package Persistence.webentities;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import Persistence.Entities.Movie;
import Persistence.Entities.Review;

@SessionScoped
@Named("current_movie")
public class CurrentMovie implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private MovieWithAverageReview movie;
	private List<Review> reviews;
	private int quantity = 1;
	
	public CurrentMovie(){}
	
	public CurrentMovie(Movie movie, Integer averageReview, List<Review> reviews){
		this.movie = new MovieWithAverageReview(movie, averageReview);
		this.reviews = reviews;
	}
	
	public void setCurrentMovie(CurrentMovie currentMovie){
		this.movie = new MovieWithAverageReview(currentMovie.getMovie(), currentMovie.getAverageReview());
		this.reviews = currentMovie.getReviews();
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
}	