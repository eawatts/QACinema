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
	
	@Column(name="is_discontinued", nullable = false)
	private boolean isDiscontinued;
	
	@Column(name = "movie_poster_filepath", nullable=false)
	private String movie_poster_filepath;
	
	@Column(name = "movie_banner_filepath", nullable=false)
	private String movie_banner_filepath;
	
	@Column(name = "movie_trailer_path", nullable=false)
	private String movie_trailer_path;

	public Movie(){};
	
	public Movie(int id, String name, boolean isDiscontinued, String movie_poster_filepath, String movie_banner_filepath, String movie_trailer_path){
		this.id=id;
		this.name=name;
		this.isDiscontinued=isDiscontinued;
		this.movie_poster_filepath = movie_poster_filepath;
		this.movie_banner_filepath = movie_banner_filepath;
		this.movie_trailer_path = movie_trailer_path;
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
	
}
