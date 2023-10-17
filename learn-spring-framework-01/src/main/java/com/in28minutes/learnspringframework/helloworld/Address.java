package com.in28minutes.learnspringframework.helloworld;

public class Address {
	String firstLine;
	String city;

	@Override
	public String toString() {
		return "Address [firstLine=" + firstLine + ", city=" + city + "]";
	}

	public String getFirstLine() {
		return firstLine;
	}

	public void setFirstLine(String firstLine) {
		this.firstLine = firstLine;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Address(String firstLine, String city) {
		this.firstLine = firstLine;
		this.city = city;
	}

}
