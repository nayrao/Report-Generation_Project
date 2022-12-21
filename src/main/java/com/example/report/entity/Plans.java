package com.example.report.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Table
@Entity
@Data
public class Plans {
	@Id
	@GeneratedValue
	private Integer planId;
	private String planName;
	

}
