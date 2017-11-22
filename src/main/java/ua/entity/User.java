package ua.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="_user")
public class User extends AbstractEntity {
	
	
	private String email;
	
	private String password;
	
	private Role role;
	
	@OneToOne(mappedBy="user",  orphanRemoval=true, cascade = CascadeType.PERSIST)
	private Owner owner;
	
	@OneToOne(mappedBy="user",  orphanRemoval=true, cascade = CascadeType.PERSIST)
	private Transporter transporter;
	
	@OneToMany(mappedBy="user")
	private List<Comment> comments;
	
	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public Transporter getTransporter() {
		return transporter;
	}

	public void setTransporter(Transporter transporter) {
		this.transporter = transporter;
	}

}
