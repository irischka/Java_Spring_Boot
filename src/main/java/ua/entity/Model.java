package ua.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="model", indexes= @Index(columnList = "name", unique = true))
public class Model extends AbstractEntityName{

	@ManyToOne(fetch=FetchType.LAZY)
	private Brand brand;
	
	@OneToMany(mappedBy="model")
	private List<Transporter> transporters = new ArrayList<>();

	public Model(String name) {
		super(name);
	}

	public Model() {
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public Model(String name, Brand brand) {
		super(name);
		this.brand = brand;
	}

}
