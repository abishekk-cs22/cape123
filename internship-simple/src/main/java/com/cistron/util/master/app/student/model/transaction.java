package com.cistron.util.master.app.student.model;

import com.cistron.util.master.app.gender.model.Gender;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="transaction")
public class transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String description;
	private int amount;
	private String transaction_mode;
	
	public transaction(int id, String description, int amount, String transaction_mode) {
		super();
		this.id = id;
		this.description = description;
		this.amount = amount;
		this.transaction_mode = transaction_mode;
	}

	public transaction() {
		super();
	}
	
	
}

