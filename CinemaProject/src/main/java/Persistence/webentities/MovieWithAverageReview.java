package Persistence.webentities;

import javax.enterprise.context.SessionScoped;

import Persistence.Entities.Movie;

@SessionScoped
public class MovieWithAverageReview {

	private Movie movie;
	private Integer averageReview;

	public MovieWithAverageReview(Movie movie, Integer averageReview) {
		this.movie = movie;
		this.averageReview = averageReview;
	}

	public Movie getMovie() {
		return this.movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Integer getAverageReview() {
		return this.averageReview;
	}

	public void setAverageReview(Integer averageReview) {
		this.averageReview = averageReview;
	}
}
