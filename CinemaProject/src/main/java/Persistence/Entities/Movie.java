package Persistence.Entities;

import javax.persistence.*;

@Entity
@Table(name="Movie")
public class Movie {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="name", nullable = false, length = 100)
	private String name;
	
	@Column(name="description", nullable = false, length = 500)
	private String description;
	
	@Column(name="is_discontinued", nullable = false)
	private boolean isDiscontinued;
	
	@Column(name = "movie_poster_filepath", nullable=false)
	private String movie_poster_filepath;
	
	@Column(name = "movie_banner_filepath", nullable=false)
	private String movie_banner_filepath;
	
	@Column(name = "movie_trailer_path", nullable=false)
	private String movie_trailer_path;
	
	@Column(name = "age_rating", nullable=false)
	private Integer age_rating;

	public Movie(){};
	
	public Movie(int id, String name, String description, boolean isDiscontinued, String movie_poster_filepath,
			String movie_banner_filepath, String movie_trailer_path, Integer age_rating){
		this.id=id;
		this.name=name;
		this.description = description;
		this.isDiscontinued=isDiscontinued;
		this.movie_poster_filepath = movie_poster_filepath;
		this.movie_banner_filepath = movie_banner_filepath;
		this.movie_trailer_path = movie_trailer_path;
		this.age_rating = age_rating;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isDiscontinued() {
		return isDiscontinued;
	}

	public void setDiscontinued(boolean isDiscontinued) {
		this.isDiscontinued = isDiscontinued;
	}

	public String getMovie_poster_filepath() {
		return movie_poster_filepath;
	}

	public void setMovie_poster_filepath(String movie_poster_filepath) {
		this.movie_poster_filepath = movie_poster_filepath;
	}

	public String getMovie_banner_filepath() {
		return movie_banner_filepath;
	}

	public void setMovie_banner_filepath(String movie_banner_filepath) {
		this.movie_banner_filepath = movie_banner_filepath;
	}

	public String getMovie_trailer_path() {
		return movie_trailer_path;
	}

	public void setMovie_trailer_path(String movie_trailer_path) {
		this.movie_trailer_path = movie_trailer_path;
	}

	public Integer getAge_rating() {
		return age_rating;
	}

	public void setAge_rating(Integer age_rating) {
		this.age_rating = age_rating;
	}
	
}
