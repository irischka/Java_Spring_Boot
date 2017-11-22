package ua.model.request;

import org.hibernate.validator.constraints.NotBlank;
import ua.entity.City;
import ua.entity.Goods;
import ua.entity.Owner;
import ua.validation.anotation.UniqueEmail;
import ua.validation.anotation.UniquePasswordOwner;
import ua.validation.anotation.UniquePhone;

import javax.validation.constraints.Size;

@UniquePasswordOwner(message = "sdfdgdhjfhjj")
public class OwnerRequest  {
	
	private Integer id;
	
	private Integer userId;
	
	private Integer ownerId;
	
	private Integer transporterId;
	
	@UniqueEmail(message = "Користувач з таким email уже зареєстрований")
	@NotBlank(message = "Поле не може бути пустим")
	private String email;

	@Size(min = 3, max = 30, message = "Розмір паролю повинен бути в межах від 3 до 30 символів!")
	private String password;
	
	@Size(min = 3, max = 30, message = "Розмір паролю повинен бути в межах від 3 до 30 символів!")
	private String repeatPassword;
	
	@NotBlank(message = "Поле не може бути пустим")
	private String name;

	@UniquePhone(message = "Такий номер телефону вже існує БД")
	@NotBlank(message = "Поле не може бути пустим")
	private String phone;
	
	@NotBlank(message = "Поле не може бути пустим")
	private String address;
	
	private String count;
	
	private Goods goods;
	
	private String weight;
	
	private String height;
	
	private String width;
	
	private String length;
	
	private City cityFrom;
	
	private City cityTo;
	
	private Owner owner;
	
	private String price;

	public OwnerRequest() {
		super();
	}

	public OwnerRequest(Integer id, Integer userId,String email, String password, String name, String phone,String address, Integer count) {
		super();
		this.id = id;
		this.userId = userId;
		this.email = email;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.count = String.valueOf(count);
	}
	
	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public Integer getTransporterId() {
		return transporterId;
	}

	public void setTransporterId(Integer transporterId) {
		this.transporterId = transporterId;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public City getCityFrom() {
		return cityFrom;
	}

	public void setCityFrom(City cityFrom) {
		this.cityFrom = cityFrom;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Integer getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}

	public City getCityTo() {
		return cityTo;
	}

	public void setCityTo(City cityTo) {
		this.cityTo = cityTo;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
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

	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
