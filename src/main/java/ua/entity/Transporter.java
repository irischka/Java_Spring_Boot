package ua.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="transporter")
public class Transporter extends AbstractEntityName {

	private BigDecimal rate;
	
	@Column(name= "count_votes")
	private int countVotes;
	
	@Column(name = "sum_rate")
	private BigDecimal sumRate;
	
	private int maxWeight;
	
	private String photoUrl;
	
	private int version;
	
	@Column(name="_count")
	private int count;
	
	private int age;
	
	private String phone;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Model model;

	private int carAge;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private City cityArrive;
	
	private LocalDateTime dateArrive;
	
	
//	@Enumerated
//	private Status status;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private State state;
	
	@OneToOne
	private User user;
	
	private Role role;
	
	@ManyToMany
	@JoinTable(name="cargo_transporter",
	joinColumns= @JoinColumn (name="transporter_id"),
	inverseJoinColumns = @JoinColumn(name = "cargo_id"))
	private List<Cargo> cargos = new ArrayList<>();
	
	public BigDecimal getSumRate() {
		return sumRate;
	}
	public void setSumRate(BigDecimal sumRate) {
		this.sumRate = sumRate;
	}
	public int getCountVotes() {
		return countVotes;
	}
	public void setCountVotes(int countVotes) {
		this.countVotes = countVotes;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public List<Cargo> getCargos() {
		return cargos;
	}
	public void setCargos(List<Cargo> cargos) {
		this.cargos = cargos;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	//	public Status getStatus() {
//		return status;
//	}
//
//	public void setStatus(Status status) {
//		this.status = status;
//	}
//	
	public BigDecimal getRate() {
		return rate;
	}
	public void setRate(BigDecimal rate) {
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
	public Model getModel() {
		return model;
	}
	public void setModel(Model model) {
		this.model = model;
	}
	public int getCarAge() {
		return carAge;
	}
	public void setCarAge(int carAge) {
		this.carAge = carAge;
	}
	public City getCityArrive() {
		return cityArrive;
	}
	public void setCityArrive(City cityArrive) {
		this.cityArrive = cityArrive;
	}
	public LocalDateTime getDateArrive() {
		return dateArrive;
	}
	public void setDateArrive(LocalDateTime dateArrive) {
		this.dateArrive = dateArrive;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
}
