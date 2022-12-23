package com.example.report.rest;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.report.entity.CitizenPlan;
import com.example.report.entity.SearchRequest;
import com.example.report.service.ReportService;

@RestController
public class ReportsController {
	@Autowired
	private ReportService service;

	@GetMapping("/getPlan")
	public List<String> getPlaneNames(){
		return service.getPlanName();
		
	}
	@GetMapping("/getStatus")
	public List<String> getPlanStatus(){
		return service.getPlanStatus();
	}
	
	@GetMapping("/search")
	public List<CitizenPlan> searchBasedOnPlanNameAndPlanStatus(@RequestBody SearchRequest searchRequest){
		
		return service.getCitizenPlansBasedOnSearch(searchRequest);
		
	}
	
	@GetMapping("/excel")
	public void generateExcelReport(HttpServletResponse response) throws Exception {
		response.setContentType("application/octet-stream");
		String headerKey="Content-Disposition";
		String headerValue="attachement; filename=citizenplans.xls";
		response.setHeader(headerKey, headerValue);
		service.exportExcel(response);
	}
	@GetMapping("/pdf")
	public void exportPdf(HttpServletResponse response) throws Exception {
		response.setContentType("application/pdf");
		String headerKey="Content-Disposition";
		String headerValue="attachement; filename=citizenplans.pdf";
		response.setHeader(headerKey, headerValue);
		service.exportExcel(response);
	}
	
}
