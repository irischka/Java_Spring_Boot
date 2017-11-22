package ua.model.filter;

import java.util.regex.Pattern;

public class OwnerFilter {
	
	private static final Pattern INT_PATTERN = Pattern.compile("^([0-9]{1,10})$");
	
	private static final Pattern STRING_PATTERN = Pattern.compile("^<([a-z]+)([^>]+)*(?:>(.*)<\\/\\1>|\\s+\\/>)$");
	
	private String name = "";
	
	private String Phone = "";
	
	private String minCount = "";

	private String maxCount = "";
	
	private String address = "";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if(STRING_PATTERN.matcher(name).matches());
		this.name = name;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		if(STRING_PATTERN.matcher(phone).matches());
		Phone = phone;
	}

	public String getMinCount() {
		return minCount;
	}

	public void setMinCount(String minCount) {
		if(INT_PATTERN.matcher(minCount).matches());
		this.minCount = minCount;
	}

	public String getMaxCount() {
		return maxCount;
	}

	public void setMaxCount(String maxCount) {
		if(INT_PATTERN.matcher(maxCount).matches());
		this.maxCount = maxCount;
	}

	public String getAddress() {
		if(STRING_PATTERN.matcher(address).matches());
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
}
