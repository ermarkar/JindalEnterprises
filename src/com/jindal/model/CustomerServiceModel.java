package com.jindal.model;

import java.util.Date;

public class CustomerServiceModel
{
	int customer_id;
	String first_name;
	String last_name;
	String firm_name;
	String address;
	String city;
	String tinNo;
	String mobile_no;
	String phone;
	String fax_no;
	Date created_on;
        double tax;
        private int rowcount;
        
    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }
        
    
    
        
	
	public String getTinNo() {
		return tinNo;
	}
	public void setTinNo(String tinNo) {
		this.tinNo = tinNo;
	}
	
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getFirm_name() {
		return firm_name;
	}
	public void setFirm_name(String firm_name) {
		this.firm_name = firm_name;
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
	public String getMobile_no() {
		return mobile_no;
	}
	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getFax_no() {
		return fax_no;
	}
	public void setFax_no(String fax_no) {
		this.fax_no = fax_no;
	}
	public Date getCreated_on() {
		return created_on;
	}
	public void setCreated_on(Date created_on) {
		this.created_on = created_on;
	}

    @Override
    public String toString() {
        return "CustomerServiceModel{" + "customer_id=" + customer_id + ", first_name=" + first_name + ", last_name=" + last_name + ", firm_name=" + firm_name + ", address=" + address + ", city=" + city + ", tinNo=" + tinNo + ", mobile_no=" + mobile_no + ", phone=" + phone + ", fax_no=" + fax_no + ", created_on=" + created_on + ", tax=" + tax + '}';
    }

    public int getRowcount() {
        return rowcount;
    }

    public void setRowcount(int rowcount) {
        this.rowcount = rowcount;
    }
	
}
