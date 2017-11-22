
package ua.model.view;

public class OwnerView {

	private Integer id;

	private String email;

	private String password;
	
	private String name;

	private String phone;

	private int count;

	private String address;

	

	public OwnerView(Integer id, String name, String phone, int count, String address) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.count = count;
		this.address = address;
	}

	public OwnerView(Integer id, String email, String password, String name, String phone, int count, String address) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.count = count;
		this.address = address;
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
