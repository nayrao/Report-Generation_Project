package com.example.report.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Table
@Entity
@Data
public class Plans {
	private Integer planId;
	private String planName;
	private String planStatus;

}
