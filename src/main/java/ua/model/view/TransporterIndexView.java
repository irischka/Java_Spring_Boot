package ua.model.view;

import java.math.BigDecimal;

public class TransporterIndexView {

	private Integer id;
	
	private String rate;
	
	private int maxWeight;
	
	private String photoUrl;
	
	private int version;
	
	private String name;
	
	private int count;
	
	public TransporterIndexView() {
	}

	public TransporterIndexView(Integer id, BigDecimal rate, int maxWeight, String name, int count, String photoUrl) {
		super();
		this.id = id;
		this.rate = String.valueOf(rate);
		this.maxWeight = maxWeight;
		this.name = name;
		this.count = count;
		this.photoUrl = photoUrl;
	}
	
	public TransporterIndexView(Integer id, BigDecimal rate, int maxWeight, String photoUrl, int version, String name, 	int count) {
		super();
		this.id = id;
		this.rate = String.valueOf(rate);
		this.maxWeight = maxWeight;
		this.photoUrl = photoUrl;
		this.version = version;
		this.name = name;
		this.count = count;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}
