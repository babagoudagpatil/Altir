package com.example.Altir.schemas;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.mapping.AccessOptions.GetOptions.GetNulls;

@Entity
@Table
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Double Amount;
	
	private LocalDate bookingdate;
	
	public Double getAmount() {
		return Amount;
	}

	public void setAmount(Double amount) {
		Amount = amount;
	}

	public LocalDate getBookingdate() {
		return bookingdate;
	}

	public void setBookingdate(LocalDate bookingdate) {
		this.bookingdate = bookingdate;
	}
	
	
	
}
