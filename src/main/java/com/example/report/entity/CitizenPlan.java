package com.example.report.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "CITIZENS_PLAN_INFO")
public class CitizenPlan {
	@Id
	private Integer cid;
	@Column(name = "PLAN_NAME")
	private String planName;
	private String planStatus;
	private String cname;
	private String cemail;
	private String gender;
	private Long phno;
	private Long ssn;

}
