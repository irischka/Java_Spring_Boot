package ua.entity;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="brand", indexes= @Index(columnList = "name") )
public class Brand extends AbstractEntityName {
	
	@OneToMany(mappedBy= "brand")
	private List<Model> models = new ArrayList<>();
	
	public Brand(String name) {
		super(name);
	}

	public Brand() {
	}

	public List<Model> getModels() {
		return models;
	}

	public void setModels(List<Model> models) {
		this.models = models;
	}

}
