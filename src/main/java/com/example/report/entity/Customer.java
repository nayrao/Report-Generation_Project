package com.example.report.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Table
@Entity
@Data
public class Customer {
	@Id
	@GeneratedValue
	private Integer customerId;
	private String customerName;
	private String customerEmail;
	private Long mobileNumber;
	private boolean gender;
	private Long serialNo;
	private String status;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="planId", nullable=true)
	private Plans plans;
}
