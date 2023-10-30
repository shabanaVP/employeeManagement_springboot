package com.springbootjdbcpostgresql.model;

public class Employee {
	

    private String fname;
	private String lname;
	private int id;
	private String tel;
	private String email;
	private String address ;
	private String city;
    private String state;

	private int zip;
	public Employee() {
    }
	
	public Employee(String fname, String lname,int id,  String tel,String email,String address, String city, String state, int zip)
	{

		this.fname = fname;
		this.lname = lname;
		this.id = id;
		this.tel = tel;
		this.email = email;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	

	

	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}


	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}




//
//	@Override
//	public String toString() {
//		return "Employee[id="+ id+", fname=" +fname + ", lname="+lname +", address=" + address + ", city="+city+", tel="+tel+","
//				+ "state="+state+",email="+email+",zip="+zip+"]";
//	}
//

}
