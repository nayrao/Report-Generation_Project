package com.example.report.rest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.report.entity.CitizenPlan;
import com.example.report.entity.SearchRequest;
import com.example.report.service.ReportService;

@RestController
public class ReportsController {
	@Autowired
	private ReportService service;

	/*
	 * @GetMapping("/getPlan") public List<String> getPlaneNames(){ return
	 * service.getPlanName(); }
	 */
	@GetMapping("/plans")
	public ResponseEntity<List<String>> getPlanNames(){
		List<String> planName = service.getPlanName();
	
		return new ResponseEntity<List<String>>(planName, HttpStatus.OK);
		
	}
	
	@GetMapping("/getStatus")
	public List<String> getPlanStatus(){
		return service.getPlanStatus();
	}
	
	@PostMapping("/search")
	public List<CitizenPlan> searchBasedOnPlanNameAndPlanStatus(@RequestBody SearchRequest searchRequest){
		
		return service.getCitizenPlansBasedOnSearch(searchRequest);
		
	}
	
	@GetMapping("/export/excel")
	public void generateExcelReport(HttpServletResponse response,@RequestParam SearchRequest searchRequest) throws Exception {
		response.setContentType("application/octet-stream");
		String headerKey="Content-Disposition";
		String headerValue="attachement; filename=citizenplans.xls";
		response.setHeader(headerKey, headerValue);
		service.exportExcel(response,searchRequest);
		response.flushBuffer();
	}
	
	@GetMapping("/export/pdf")
	public void generatePdf(HttpServletResponse response) throws Exception {
		response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
         
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=citizenInfo_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);
         service.exportPdf(response);
         
        
	}
	
	
}
