package ua.model.view;


public class ModelView {

	private Integer id;
	
	private String brand;
	
	private String name;

	public ModelView(Integer id, String brand, String name) {
		super();
		this.id = id;
		this.brand = brand;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
