package com.pavan.persons;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Person implements Serializable {
	@Id
	private int eid;
	private String firstName;
	private String lastName;
	
	@OneToMany(
	        cascade = CascadeType.ALL,
	        orphanRemoval = true,
	        mappedBy = "person"
	    )
	Set <Adress> ad= new HashSet<Adress>();
	
	public void setAd(Set<Adress> ad) {
		this.ad = ad;
	}
	
	public Set<Adress> getAd() {
		return ad;
	}

	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@Override
	public String toString() {
		return "Person [eid=" + eid + ", firstName=" + firstName + ", lastName=" + lastName + ", ad=" + ad + "]";
	}
	
	

}
