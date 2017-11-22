package ua.model.filter;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class CargoFilter {

	private static final Pattern INT_PATTERN = Pattern.compile("^([0-9]{1,10})$");
		
	private static final Pattern DECIMAL_PATTERN = Pattern.compile("^([0-9]{1,18}\\.[0-9]{0,2})|([0-9]{1,18}\\,[0-9]{0,2})|([0-9]{1,18})$");
	
	private static final Pattern STRING_PATTERN = Pattern.compile("^<([a-z]+)([^>]+)*(?:>(.*)<\\/\\1>|\\s+\\/>)$");
	
	private String minWeight = "";
	
	private String maxWeight = "";
	
	private String minHeight = "";
	
	private String maxHeight = "";
	
	private String minWidth = "";
	
	private String maxWidth = "";
	
	private String minLength = "";
	
	private String maxLength = "";
	
	private String minPrice = "";
	
	private String maxPrice = "";
	
	private String transporterId = "";
	
	private String status="";
	
	private List<String> cityIds = new ArrayList<>();
	
	private List<String> cityToIds = new ArrayList<>();
	
	private List<String> goodsIds= new ArrayList<>();

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		if(STRING_PATTERN.matcher(maxHeight).matches());
		this.status = status;
	}

	public String getTransporterId() {
		return transporterId;
	}

	public void setTransporterId(String transporterId) {
		this.transporterId = transporterId;
	}

	public List<String> getGoodsIds() {
		return goodsIds;
	}

	public void setGoodsIds(List<String> goodsIds) {
		this.goodsIds = goodsIds;
	}

	public String getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(String minPrice) {
		if(DECIMAL_PATTERN.matcher(minPrice).matches());
		this.minPrice = minPrice;
	}

	public String getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(String maxPrice) {
		if(DECIMAL_PATTERN.matcher(maxPrice).matches());
		this.maxPrice = maxPrice;
	}

	public List<String> getCityToIds() {
		return cityToIds;
	}

	public void setCityToIds(List<String> cityToIds) {
		this.cityToIds = cityToIds;
	}

	public String getMinHeight() {
		return minHeight;
	}

	public void setMinHeight(String minHeight) {
		if(INT_PATTERN.matcher(minHeight).matches());
		this.minHeight = minHeight;
	}

	public String getMaxHeight() {
		return maxHeight;
	}

	public void setMaxHeight(String maxHeight) {
		if(INT_PATTERN.matcher(maxHeight).matches());
		this.maxHeight = maxHeight;
	}

	public String getMinWidth() {
		return minWidth;
	}

	public void setMinWidth(String minWidth) {
		if(INT_PATTERN.matcher(minWidth).matches());
		this.minWidth = minWidth;
	}

	public String getMaxWidth() {
		return maxWidth;
	}

	public void setMaxWidth(String maxWidth) {
		if(INT_PATTERN.matcher(maxWidth).matches());
		this.maxWidth = maxWidth;
	}

	public String getMinLength() {
		return minLength;
	}

	public void setMinLength(String minLength) {
		if(INT_PATTERN.matcher(minLength).matches());
		this.minLength = minLength;
	}

	public String getMaxLength() {
		return maxLength;
	}

	public void setMaxLength(String maxLength) {
		if(INT_PATTERN.matcher(maxLength).matches());
		this.maxLength = maxLength;
	}

	public List<String> getCityIds() {
		return cityIds;
	}

	public void setCityIds(List<String> cityIds) {
		this.cityIds = cityIds;
	}

	public String getMinWeight() {
		return minWeight;
	}

	public void setMinWeight(String minWeight) {
		if(INT_PATTERN.matcher(minWeight).matches());
		this.minWeight = minWeight;
	}

	public String getMaxWeight() {
		return maxWeight;
	}

	public void setMaxWeight(String maxWeight) {
		if(INT_PATTERN.matcher(maxWeight).matches());
		this.maxWeight = maxWeight;
	}

}
