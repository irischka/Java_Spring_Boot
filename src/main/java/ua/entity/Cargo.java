package ua.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="cargo")
public class Cargo extends AbstractEntity{
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Goods goods;
	
	private int weight;
	
	private int height;
	 
	private int width;
	
	private int length;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private City cityFrom;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private City cityTo;
	
	private BigDecimal price;
	 
	@ManyToOne(fetch=FetchType.LAZY)
	private Owner owner;
	
	@Column(name = "tr_id")
	private Integer transporterId;
	
	@Column(name="status")
	private String status;
	
	@ManyToMany
	@JoinTable(name="cargo_transporter",
	joinColumns= @JoinColumn (name="cargo_id"),
	inverseJoinColumns = @JoinColumn(name = "transporter_id"))
	private List<Transporter> transporters = new ArrayList<>();

	public Cargo(Goods goods, int weight, int height, int width, int length, City cityFrom, City cityTo,
                 BigDecimal price) {
		super();
		this.goods = goods;
		this.weight = weight;
		this.height = height;
		this.width = width;
		this.length = length;
		this.cityFrom = cityFrom;
		this.cityTo = cityTo;
		this.price = price;
	}

	public Cargo() {
		super();
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getTransporterId() {
		return transporterId;
	}

	public void setTransporterId(Integer transporterId) {
		this.transporterId = transporterId;
	}

	public List<Transporter> getTransporters() {
		return transporters;
	}

	public void setTransporters(List<Transporter> transporters) {
		this.transporters = transporters;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public City getCityFrom() {
		return cityFrom;
	}

	public void setCityFrom(City cityFrom) {
		this.cityFrom = cityFrom;
	}

	public City getCityTo() {
		return cityTo;
	}

	public void setCityTo(City cityTo) {
		this.cityTo = cityTo;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}
}
