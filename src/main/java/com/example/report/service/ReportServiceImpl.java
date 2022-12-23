package com.example.report.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.report.entity.CitizenPlan;
import com.example.report.entity.SearchRequest;
import com.example.report.repo.ReportRepository;

@Service
public class ReportServiceImpl implements ReportService{
	@Autowired
	private ReportRepository repository;

	@Override
	public List<String> getPlanName() {
		// TODO Auto-generated method stub
		return repository.findByPlanName();
	}

	@Override
	public List<String> getPlanStatus() {
		// TODO Auto-generated method stub
		return repository.findByPlanStatus();
	}

	@Override
	public List<CitizenPlan> getCitizenPlansBasedOnSearch(SearchRequest searchRequest) {
		
		CitizenPlan citizenPlan=new CitizenPlan();
		
		if(searchRequest.getPlanName()!=null && !searchRequest.getPlanName().equals("")) {
			citizenPlan.setPlanName(searchRequest.getPlanName());
		}
		if(searchRequest.getPlanStatus()!=null && !searchRequest.getPlanStatus().equals(""))
		{
			citizenPlan.setPlanStatus(searchRequest.getPlanStatus());
		}
		 org.springframework.data.domain.Example<CitizenPlan> example = org.springframework.data.domain.Example.of(citizenPlan);
		
		List<CitizenPlan> citizenRecords = repository.findAll(example);
		
		return citizenRecords;
		  
	}

	@Override
	public void exportExcel(HttpServletResponse response) throws IOException  {
		List<CitizenPlan> citizenPlans = repository.findAll();
		
		HSSFWorkbook workbook=new HSSFWorkbook();
		HSSFSheet createSheet = workbook.createSheet("Citizens Info");
		HSSFRow createRow = createSheet.createRow(0);
		
		createRow.createCell(0).setCellValue("CID");
		createRow.createCell(1).setCellValue("PLAN_NAME");
		createRow.createCell(2).setCellValue("PLAN_STATUS");
		createRow.createCell(3).setCellValue("CNAME");
		createRow.createCell(4).setCellValue("GENDER");
		createRow.createCell(5).setCellValue("PHNO");
		createRow.createCell(6).setCellValue("SSN");
		
		int dataRowIndex=1;
		
		for(CitizenPlan citizenPlan:citizenPlans) {
			HSSFRow hssfRow = createSheet.createRow(dataRowIndex);
			hssfRow.createCell(0).setCellValue(citizenPlan.getCid());
			hssfRow.createCell(1).setCellValue(citizenPlan.getPlanName());
			hssfRow.createCell(2).setCellValue(citizenPlan.getPlanStatus());
			hssfRow.createCell(3).setCellValue(citizenPlan.getCname());
			hssfRow.createCell(4).setCellValue(citizenPlan.getGender());
			hssfRow.createCell(5).setCellValue(citizenPlan.getPhno());
			hssfRow.createCell(6).setCellValue(citizenPlan.getSsn());
			
			dataRowIndex ++;
		}
		
		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		workbook.close();
		outputStream.close();
		
		
	}

	@Override
	public void exportPdf(HttpServletResponse response) throws Exception {
List<CitizenPlan> citizenPlans = repository.findAll();
		
		HSSFWorkbook workbook=new HSSFWorkbook();
		HSSFSheet createSheet = workbook.createSheet("Citizens Info");
		HSSFRow createRow = createSheet.createRow(0);
		
		createRow.createCell(0).setCellValue("CID");
		createRow.createCell(1).setCellValue("PLAN_NAME");
		createRow.createCell(2).setCellValue("PLAN_STATUS");
		createRow.createCell(3).setCellValue("CNAME");
		createRow.createCell(4).setCellValue("GENDER");
		createRow.createCell(5).setCellValue("PHNO");
		createRow.createCell(6).setCellValue("SSN");
		
		int dataRowIndex=1;
		
		for(CitizenPlan citizenPlan:citizenPlans) {
			HSSFRow hssfRow = createSheet.createRow(dataRowIndex);
			hssfRow.createCell(0).setCellValue(citizenPlan.getCid());
			hssfRow.createCell(1).setCellValue(citizenPlan.getPlanName());
			hssfRow.createCell(2).setCellValue(citizenPlan.getPlanStatus());
			hssfRow.createCell(3).setCellValue(citizenPlan.getCname());
			hssfRow.createCell(4).setCellValue(citizenPlan.getGender());
			hssfRow.createCell(5).setCellValue(citizenPlan.getPhno());
			hssfRow.createCell(6).setCellValue(citizenPlan.getSsn());
			
			dataRowIndex ++;
		}
		
		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		workbook.close();
		outputStream.close();
		
		
		
	}

}
