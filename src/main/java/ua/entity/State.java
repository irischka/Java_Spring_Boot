package ua.entity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="state")
public class State extends AbstractEntityName {
	
	@OneToMany(mappedBy="state")
	private List<Transporter> transporters = new ArrayList<>();
	
	public State(String name) {
		super(name);
	}
	
	
	public State() {
		
	}


	public State(Integer id) {
		this.getId();
	}

}
