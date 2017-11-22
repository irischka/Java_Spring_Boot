package ua.model.request;

import ua.entity.City;
import ua.entity.Comment;
import ua.entity.Model;
import ua.entity.State;

import java.time.LocalDateTime;
import java.util.List;

public class TransporterRequest {

	private Integer id;
	
	private String rate;
	
	private String maxWeight;
	
	private String photoUrl;

	private int version;
	
	private String name;
	
	private String count;
	
	private String age;
	
	private String phone;
	
	private Model model;
	
	private String carAge;
	
	private City cityArrive;
	
	private LocalDateTime dateArrive;
	
	private State state;
	
	private List<Comment> comments;

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public String getMaxWeight() {
		return maxWeight;
	}

	public void setMaxWeight(String maxWeight) {
		this.maxWeight = maxWeight;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	public String getCarAge() {
		return carAge;
	}

	public void setCarAge(String carAge) {
		this.carAge = carAge;
	}

	public City getCityArrive() {
		return cityArrive;
	}

	public void setCityArrive(City cityArrive) {
		this.cityArrive = cityArrive;
	}

	public LocalDateTime getDateArrive() {
		return dateArrive;
	}

	public void setDateArrive(LocalDateTime dateArrive) {
		this.dateArrive = dateArrive;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
	
	
}
