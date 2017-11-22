package ua.model.filter;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class TransporterFilter {
	
	private static final Pattern INT_PATTERN = Pattern.compile("^([0-9]{1,10})$");
	
	private static final Pattern DECIMAL_PATTERN = Pattern.compile("^([0-9]{1,18}\\.[0-9]{0,2})|([0-9]{1,18}\\,[0-9]{0,2})|([0-9]{1,18})$");
	
	private static final Pattern STRING_PATTERN = Pattern.compile("^<([a-z]+)([^>]+)*(?:>(.*)<\\/\\1>|\\s+\\/>)$");
	
//	private static final Pattern DATE_PATTERN = Pattern.compile("^([2][0]\\d{2}\\/([0]\\d|[1][0-2])\\/([0-2]\\d|[3][0-1]))$|^([2][0]\\d{2}\\/([0]\\d|[1][0-2])\\/([0-2]\\d|[3][0-1])\\s([0-1]\\d|[2][0-3])\\:[0-5]\\d\\:[0-5]\\d)$");
 
	private String minRate = "";
	
	private String maxRate = "";
	
	private String minWeight = "";
	
	private String maxWeight = "";
	
	private String minCount = "";
	
	private String maxCount = "";
	
	private String minAge = "";
	
	private String maxAge = "";
	
	private String phones = "";
	
	private String names = "";
	
	private String minCarAge ="";
	
	private String maxCarAge ="";
	
	private List<String> modeIds = new ArrayList<>();
	
	private List<String> brandlIds = new ArrayList<>();
	
	private List<String> cityIds = new ArrayList<>();
	
	private List<String> stateIds = new ArrayList<>();
	
	private String date;
 
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		if(STRING_PATTERN.matcher(date).matches());
		this.date = date;
	}

	public String getPhones() {
		return phones;
	}

	public void setPhones(String phones) {
		if(STRING_PATTERN.matcher(phones).matches());
		this.phones = phones;
	}

	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		if(STRING_PATTERN.matcher(names).matches());
		this.names = names;
	}

	public List<String> getStateIds() {
		return stateIds;
	}

	public void setStateIds(List<String> stateIds) {
		this.stateIds = stateIds;
	}

	public String getMinCarAge() {
		return minCarAge;
	}

	public void setMinCarAge(String minCarAge) {
		if(INT_PATTERN.matcher(minCarAge).matches());
		this.minCarAge = minCarAge;
	}

	public String getMaxCarAge() {
		return maxCarAge;
	}

	public void setMaxCarAge(String maxCarAge) {
		if(INT_PATTERN.matcher(maxCarAge).matches());
		this.maxCarAge = maxCarAge;
	}


	public String getMinAge() {
		return minAge;
	}

	public void setMinAge(String minAge) {
		if(INT_PATTERN.matcher(minAge).matches());
		this.minAge = minAge;
	}

	public String getMaxAge() {
		return maxAge;
	}

	public void setMaxAge(String maxAge) {
		if(INT_PATTERN.matcher(maxAge).matches());
		this.maxAge = maxAge;
	}

	public String getMinRate() {
		return minRate;
	}

	public void setMinRate(String minRate) {
		if(DECIMAL_PATTERN.matcher(minRate).matches());
		this.minRate = minRate;
	}

	public String getMaxRate() {
		return maxRate;
	}

	public void setMaxRate(String maxRate) {
		if(DECIMAL_PATTERN.matcher(maxRate).matches());
		this.maxRate = maxRate;
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

	public List<String> getModelIds() {
		return modeIds;
	}

	public void setModelIds(List<String> modelIds) {
		this.modeIds = modelIds;
	}

	public List<String> getBrandIds() {
		return brandlIds;
	}

	public void setBrandIds(List<String> brandlIds) {
		this.brandlIds = brandlIds;
	}

	public List<String> getCityIds() {
		return cityIds;
	}

	public void setCityIds(List<String> cityIds) {
		this.cityIds = cityIds;
	}
	
	
}
