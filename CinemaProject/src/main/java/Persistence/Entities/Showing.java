package Persistence.Entities;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="Showing")
public class Showing {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="day", nullable=false)
	private String day;
	
	@Column(name="times", nullable=false)
	private List<String> times;
	
	public Showing(){};
	
	public Showing(int id, String day, List<String> times){
		this.id = id;
		this.day = day;
		this.times = times;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public List<String> getTimes() {
		return times;
	}

	public void setTimes(List<String> times) {
		this.times = times;
	}
	
}
