package ua.model.request;

import org.hibernate.validator.constraints.NotBlank;
import ua.entity.Brand;
import ua.validation.anotation.UniqueModel;

public class ModelRequest {

	private Integer id;
	
	private Brand brand;
	
	@NotBlank(message = "Поле не може бути пустим")
	@UniqueModel(message = "Така модель вже існує в БД" )
	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
