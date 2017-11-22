package ua.model.request;


import org.hibernate.validator.constraints.NotBlank;
import ua.entity.*;
import ua.validation.anotation.UniqueEmail;
import ua.validation.anotation.UniquePasswordTransporter;
import ua.validation.anotation.UniquePhoneTransporter;

import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@UniquePasswordTransporter(message = "passwords are not equal")
public class TransporterRequestNew {
	
	private  Integer id;
	
	private  Integer userId;
	
	@UniqueEmail(message = "Користувач з таким email уже зареєстрований")
	@NotBlank(message = "Поле не може бути пустим")
	private String email;

	@Size(min = 2, max = 30, message = "Розмір паролю повинен бути в межах від 3 до 30 символів!")
	private String password;
	
	@Size(min = 2, max = 30, message = "Розмір паролю повинен бути в межах від 3 до 30 символів!")
	private String repeatPassword;

	@NotBlank(message = "Поле не може бути пустим")
	private String maxWeight;

	@NotBlank(message = "Поле не може бути пустим")
	private String name;

	@NotBlank(message = "Поле не може бути пустим")
	private String age;

	@UniquePhoneTransporter(message = "Такий телефон вже зареєстровано")
	@NotBlank(message = "Поле не може бути пустим")
	private String phone;

	private Model model;

	@NotBlank(message = "Поле не може бути пустим")
	private String carAge;
	
	private String rate;
	
	private String count;
	
	private City cityArrive;
	
	private LocalDateTime dateArrive;
	
	private State state;
	
	private String photoUrl;
	
	private List<Cargo> cargos;
	
	private List<Comment> comments;

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<Cargo> getCargos() {
		return cargos;
	}

	public void setCargos(List<Cargo> cargos) {
		this.cargos = cargos;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
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

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRepeatPassword() {
		return repeatPassword;
	}

	public void setRepeatPassword(String repeatPassword) {
		this.repeatPassword = repeatPassword;
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

}
