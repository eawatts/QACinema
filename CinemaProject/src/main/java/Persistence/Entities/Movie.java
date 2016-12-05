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

	public Movie(){};
	
	public Movie(int id, String name, boolean isDiscontinued){
		this.id=id;
		this.name=name;
		this.isDiscontinued=isDiscontinued;
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
	
}
