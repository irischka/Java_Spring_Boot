package ua.model.view;

import ua.entity.City;
import ua.entity.Goods;
import ua.entity.Owner;

import java.math.BigDecimal;

public class CargoView {

	private Integer id;
	
	private String goods;
	
	private int weight;
	
	private int height;
	
	private int width;
	
	private int length;
	
	private String cityFrom;
	
	private String cityTo;
	
	private String owner;
	
	private String price;
	
	private Integer transporterId;
	
	private String status;
	
	

	public CargoView(Integer id, Goods goods, int weight, int height, int width, int length, City cityFrom, City cityTo, Owner owner, BigDecimal price, Integer transporterId, String status) {
		super();
		this.id = id;
		this.goods = String.valueOf(goods.getName());
		this.weight = weight;
		this.height = height;
		this.width = width;
		this.length = length;
		this.cityFrom = String.valueOf(cityFrom.getName());
		this.cityTo = String.valueOf(cityTo.getName());
		this.owner = String.valueOf(owner);
		this.price = String.valueOf(price);
		this.transporterId=transporterId;
		this.status=status;
	}

	public CargoView(Integer id, Goods goods, int weight, int height, int width, int length, City cityFrom, City cityTo, BigDecimal price) {
		super();
		this.id = id;
		this.goods = String.valueOf(goods.getName());
		this.weight = weight;
		this.height = height;
		this.width = width;
		this.length = length;
		this.cityFrom = String.valueOf(cityFrom.getName());
		this.cityTo = String.valueOf(cityTo.getName());
		this.price = String.valueOf(price);
	}

	public CargoView(Integer id, String goods, int weight, int height, int width, int length, String cityFrom, String cityTo,  BigDecimal price) {
		this.id = id;
		this.goods = goods;
		this.weight = weight;
		this.height = height;
		this.width = width;
		this.length = length;
		this.cityFrom = cityFrom;
		this.cityTo = cityTo;
		this.price = String.valueOf(price);
	}
	
	
	public Integer getTransporterId() {
		return transporterId;
	}

	public void setTransporterId(Integer transporterId) {
		this.transporterId = transporterId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGoods() {
		return goods;
	}

	public void setGoods(String goods) {
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

	public String getCityFrom() {
		return cityFrom;
	}

	public void setCityFrom(String cityFrom) {
		this.cityFrom = cityFrom;
	}

	public String getCityTo() {
		return cityTo;
	}

	public void setCityTo(String cityTo) {
		this.cityTo = cityTo;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}


	
	
}
