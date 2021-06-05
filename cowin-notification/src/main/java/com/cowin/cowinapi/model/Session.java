package com.cowin.cowinapi.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Session {

	@JsonProperty("center_id")
	private Integer centerId;
	
	private String name;
	private String address;
	
	@JsonProperty("state_name")
	private String stateName;
	
	@JsonProperty("district_name")
	private String districtName;
	
	@JsonProperty("block_name")
	private String blockName;
	
	private Integer pincode;
	private String from;
	private String to;
	private Integer lat;
	
	@JsonProperty("long")
	private Integer _long;
	
	@JsonProperty("fee_type")
	private String feeType;
	
	@JsonProperty("session_id")
	private String sessionId;
	private String date;
	
	@JsonProperty("available_capacity_dose1")
	private Integer availableCapacityDose1;
	
	@JsonProperty("available_capacity_dose2")
	private Integer availableCapacityDose2;
	
	@JsonProperty("available_capacity")
	private Integer availableCapacity;
	private String fee;
	
	@JsonProperty("min_age_limit")
	private Integer minAgeLimit;
	private String vaccine;
	private List<String> slots = null;
	
	public Integer getCenterId() {
		return centerId;
	}
	public void setCenterId(Integer centerId) {
		this.centerId = centerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public String getDistrictName() {
		return districtName;
	}
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}
	public String getBlockName() {
		return blockName;
	}
	public void setBlockName(String blockName) {
		this.blockName = blockName;
	}
	public Integer getPincode() {
		return pincode;
	}
	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public Integer getLat() {
		return lat;
	}
	public void setLat(Integer lat) {
		this.lat = lat;
	}
	public Integer get_long() {
		return _long;
	}
	public void set_long(Integer _long) {
		this._long = _long;
	}
	public String getFeeType() {
		return feeType;
	}
	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Integer getAvailableCapacityDose1() {
		return availableCapacityDose1;
	}
	public void setAvailableCapacityDose1(Integer availableCapacityDose1) {
		this.availableCapacityDose1 = availableCapacityDose1;
	}
	public Integer getAvailableCapacityDose2() {
		return availableCapacityDose2;
	}
	public void setAvailableCapacityDose2(Integer availableCapacityDose2) {
		this.availableCapacityDose2 = availableCapacityDose2;
	}
	public Integer getAvailableCapacity() {
		return availableCapacity;
	}
	public void setAvailableCapacity(Integer availableCapacity) {
		this.availableCapacity = availableCapacity;
	}
	public String getFee() {
		return fee;
	}
	public void setFee(String fee) {
		this.fee = fee;
	}
	public Integer getMinAgeLimit() {
		return minAgeLimit;
	}
	public void setMinAgeLimit(Integer minAgeLimit) {
		this.minAgeLimit = minAgeLimit;
	}
	public String getVaccine() {
		return vaccine;
	}
	public void setVaccine(String vaccine) {
		this.vaccine = vaccine;
	}
	public List<String> getSlots() {
		return slots;
	}
	public void setSlots(List<String> slots) {
		this.slots = slots;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((centerId == null) ? 0 : centerId.hashCode());
		result = prime * result + ((sessionId == null) ? 0 : sessionId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Session)) {
			return false;
		}
		Session other = (Session) obj;
		if (centerId == null) {
			if (other.centerId != null) {
				return false;
			}
		} else if (!centerId.equals(other.centerId)) {
			return false;
		}
		if (sessionId == null) {
			if (other.sessionId != null) {
				return false;
			}
		} else if (!sessionId.equals(other.sessionId)) {
			return false;
		}
		return true;
	}
	@Override
	public String toString() {
		return "Session [centerId=" + centerId + ", name=" + name + ", address=" + address + ", stateName=" + stateName
				+ ", districtName=" + districtName + ", blockName=" + blockName + ", pincode=" + pincode + ", from="
				+ from + ", to=" + to + ", lat=" + lat + ", _long=" + _long + ", feeType=" + feeType + ", sessionId="
				+ sessionId + ", date=" + date + ", availableCapacityDose1=" + availableCapacityDose1
				+ ", availableCapacityDose2=" + availableCapacityDose2 + ", availableCapacity=" + availableCapacity
				+ ", fee=" + fee + ", minAgeLimit=" + minAgeLimit + ", vaccine=" + vaccine + ", slots=" + slots + "]";
	}
}
