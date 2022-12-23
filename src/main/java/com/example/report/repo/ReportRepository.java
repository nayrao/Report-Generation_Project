package com.example.report.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.report.entity.CitizenPlan;

public interface ReportRepository extends JpaRepository<CitizenPlan, Integer> {

	@Query("select distinct (planName) from CitizenPlan")
 	List<String> findByPlanName();
	@Query("select distinct (planStatus) from CitizenPlan")
	List<String> findByPlanStatus();
}
