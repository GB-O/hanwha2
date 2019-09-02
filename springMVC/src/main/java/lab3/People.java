package lab3;

import java.util.List;

public class People {
	String name;
	String phone;
	Car car;
	
	List<String> major;
	List<License> Licenses;
	
	public People() {
		
	}

	public People(String name, String phone, Car car) {
		super();
		this.name = name;
		this.phone = phone;
		this.car = car;
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

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public List<String> getMajor() {
		return major;
	}

	public void setMajor(List<String> major) {
		this.major = major;
	}

	public List<License> getLicenses() {
		return Licenses;
	}

	public void setLicenses(List<License> licenses) {
		Licenses = licenses;
	}

	@Override
	public String toString() {
		return "People [name=" + name + ", phone=" + phone + ", car=" + car + ", major=" + major + ", Licenses="
				+ Licenses + "]";
	}

	
	
}
