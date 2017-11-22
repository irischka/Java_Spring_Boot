package ua.model.view;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TransporterView {

	private Integer id;
	
	private String email;

	private String password;
	
	private String repeatPassword;
	
	private String rate;
	
	private int maxWeight;
	
	private String photoUrl;
	
	private int version;
	
	private String name;
	
	private int count;
	
	private int age;
	
	private String phone;
	
	private String model;
	
	private int carAge;
	
	private String cityArrive;
	
	private String dateArrive;
	
	private String state;
	
	private String status;
	
	public TransporterView(Integer id, String email, String password, int maxWeight, String name, int age, String phone, String model, int carAge) {
		super();
		this.id=id;
		this.email = email;
		this.password = password;
		this.maxWeight = maxWeight;
		this.name = name;
		this.age = age;
		this.phone = phone;
		this.model = model;
		this.carAge = carAge;
	}

	public TransporterView(Integer id, BigDecimal rate, int maxWeight, String name, int count, int age, String phone, String model, int carAge, String cityArrive , LocalDateTime  dateArrive , String state, String photoUrl) {
		super();
		this.id = id;
		this.rate = String.valueOf(rate);
		this.maxWeight = maxWeight;
		this.name = name;
		this.count = count;
		this.age = age;
		this.phone = phone;
		this.model = model;
		this.carAge = carAge;
		this.cityArrive = cityArrive;
		this.dateArrive = dateArrive.format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"));
		this.state = state;
		this.photoUrl=photoUrl;
	}

	public String getRepeatPassword() {
		return repeatPassword;
	}


	public void setRepeatPassword(String repeatPassword) {
		this.repeatPassword = repeatPassword;
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


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public int getMaxWeight() {
		return maxWeight;
	}

	public void setMaxWeight(int maxWeight) {
		this.maxWeight = maxWeight;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getCarAge() {
		return carAge;
	}

	public void setCarAge(int carAge) {
		this.carAge = carAge;
	}

	public String getCityArrive() {
		return cityArrive;
	}

	public void setCityArrive(String cityArrive) {
		this.cityArrive = cityArrive;
	}

	public String getDateArrive() {
		return dateArrive;
	}

	public void setDateArrive(String dateArrive) {
		this.dateArrive = dateArrive;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
}
