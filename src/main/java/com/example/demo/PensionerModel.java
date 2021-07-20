package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(name="mytable")

public class PensionerModel {
	
	public PensionerModel() {}
	
	public PensionerModel(String a,String b,double c,double d) {
		// TODO Auto-generated constructor stub
		this.PensionerID=a;
		this.PensionerName=b;
		this.PhoneNumber=c;
		this.StoCode=d;
	}
	
	
@Override
	public String toString() {
		return "PensionerModel [PensionerID=" + PensionerID + ", PensionerName=" + PensionerName + ", StoCode="
				+ StoCode + ", PhoneNumber=" + PhoneNumber + "]";
	}
@Id	
@GeneratedValue(strategy=GenerationType.IDENTITY)
private String PensionerID;
private String PensionerName;
private double StoCode;
private double PhoneNumber;
public String getPensionerID() {
	return PensionerID;
}
public void setPensionerID(String pensionerID) {
	PensionerID = pensionerID;
}
public String getPensionerName() {
	return PensionerName;
}
public void setPensionerName(String pensionerName) {
	PensionerName = pensionerName;
}
public double getStoCode() {
	return StoCode;
}
public void setStoCode(double stoCode) {
	StoCode = stoCode;
}
public double getPhoneNumber() {
	return PhoneNumber;
}
public void setPhoneNumber(double phoneNumber) {
	PhoneNumber = phoneNumber;
}
}
