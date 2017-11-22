package ua.entity;

import org.hibernate.validator.constraints.NotBlank;
import ua.validation.anotation.UnicCity;
import ua.validation.anotation.UniqueBrand;
import ua.validation.anotation.UniqueGoods;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractEntityName extends AbstractEntity {
	
	@UniqueGoods(message = "Такий товар вже є в БД")
	@UnicCity(message="Таке місто вже існує в БД")
	@UniqueBrand(message= "Такий бренд вже існує в БД")
	@NotBlank(message = "Поле не може бути пустим")
	private String name;

	public AbstractEntityName(String name) {
		super();
		this.name = name;
	}
	
	public AbstractEntityName() {
		super();
	}

	public String getName() {
		return name;
	}
	
	

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "AbstractEntityName [name=" + name + "]";
	}
	
}
