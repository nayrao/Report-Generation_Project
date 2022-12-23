package com.example.report.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.example.report.entity.CitizenPlan;
import com.example.report.entity.SearchRequest;

public interface ReportService {

	public List<String> getPlanName();
	
	public List<String> getPlanStatus();
	
	public List<CitizenPlan> getCitizenPlansBasedOnSearch(SearchRequest searchRequest);
	
	public void exportExcel(HttpServletResponse response) throws Exception;
	
	public void exportPdf(HttpServletResponse response) throws Exception;

	
}
