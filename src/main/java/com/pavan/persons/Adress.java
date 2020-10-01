package com.pavan.persons;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Adress implements Serializable {

public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}

private String street;
 private String city;
 private String state;
 private int postCode;
 
 @Id
 private  int aid;
 
 
 @ManyToOne
 @JoinColumn(name="person_eid")
Person person;
 
public String getStreet() {
	return street;
}
public void setStreet(String street) {
	this.street = street;
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
public int getPostCode() {
	return postCode;
}
public void setPostCode(int postCode) {
	this.postCode = postCode;
}
@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Adress ad = (Adress) o;
    return aid == ad.aid ;
           
}

@Override
public int hashCode() {
    return aid;
}
@Override
public String toString() {
	return "Adress [street=" + street + ", city=" + city + ", state=" + state + ", postCode=" + postCode + ", aid="
			+ aid + "]";
}

}


