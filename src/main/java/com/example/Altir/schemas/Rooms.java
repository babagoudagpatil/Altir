package com.example.Altir.schemas;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Rooms {

	@Id
	private Integer roomnumber;
	
	private String roomtype;
	
	private String roomdescription;
	
	private Float roomprice;
	
	private String roomstatus;

	
	public Integer getRoomnumber() {
		return roomnumber;
	}

	public void setRoomnumber(Integer roomnumber) {
		this.roomnumber = roomnumber;
	}

	public String getRoomtype() {
		return roomtype;
	}

	public void setRoomtype(String roomtype) {
		this.roomtype = roomtype;
	}
	
	

	public Float getRoomprice() {
		return roomprice;
	}

	public void setRoomprice(Float roomprice) {
		this.roomprice = roomprice;
	}

	public String getRoomdescription() {
		return roomdescription;
	}

	public void setRoomdescription(String roomdescription) {
		this.roomdescription = roomdescription;
	}

	public String getRoomstatus() {
		return roomstatus;
	}

	public void setRoomstatus(String roomstatus) {
		this.roomstatus = roomstatus;
	}
	
	
	
}
