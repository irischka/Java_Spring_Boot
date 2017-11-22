package ua.entity;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="city", indexes= @Index(columnList = "name"))
public class City extends AbstractEntityName {

	
	@OneToMany(mappedBy="cityArrive")
	private List<Transporter> transporters = new ArrayList<>();
	
	@OneToMany(mappedBy="cityFrom")
	private List<Cargo> cargosFrom = new ArrayList<>();
	
	@OneToMany(mappedBy="cityTo")
	private List<Cargo> cargosTo = new ArrayList<>();

	public City(String name) {
		super(name);
	}

	public City() {
	}

	public List<Transporter> getTransporters() {
		return transporters;
	}

	public void setTransporters(List<Transporter> transporters) {
		this.transporters = transporters;
	}

	public List<Cargo> getCargosFrom() {
		return cargosFrom;
	}

	public void setCargosFrom(List<Cargo> cargosFrom) {
		this.cargosFrom = cargosFrom;
	}

	public List<Cargo> getCargosTo() {
		return cargosTo;
	}

	public void setCargosTo(List<Cargo> cargosTo) {
		this.cargosTo = cargosTo;
	}

}