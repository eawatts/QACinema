package Persistence.Entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Review")
public class Review {

	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "rating", nullable = false)
	@NotNull
	private float rating;

	@Column(name = "comment", length = 512)
	@Size(min = 2, max = 512)
	private String comment;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	@NotNull
	private User reviewer;

	@ManyToOne
	@JoinColumn(name = "movie_id", nullable = false)
	@NotNull
	private Movie movie;
	
	public Review(int id, float rating, String comment, User reviewer, Movie movie){
		super();
		this.id = id;
		this.rating = rating;
		this.comment = comment;
		this.reviewer = reviewer;
		this.movie = movie;
	}

	public int getId() {
		return id;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(Long rating) {
		this.rating = rating;
	}
	
	public String getComment() {
		return comment;
	}
	
	public void setComment(String comment) {
		this.comment = comment;
	}

	public User getReviewer() {
		return reviewer;
	}

	public Movie getMovie() {
		return movie;
	}
	
}
