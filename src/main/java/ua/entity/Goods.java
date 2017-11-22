package ua.entity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="goods")
public class Goods extends AbstractEntityName {
	
	@OneToMany(mappedBy="goods")
	private List<Cargo> cargos = new ArrayList<>();

	public Goods(String name) {
		super(name);
	}
	
	public Goods() {
	}
	
	public List<Cargo> getCargos() {
		return cargos;
	}

	public void setCargos(List<Cargo> cargos) {
		this.cargos = cargos;
	}

	
}
