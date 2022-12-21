package com.example.report.service;

import java.io.ByteArrayInputStream;
import java.util.List;

import com.example.report.entity.Customer;

public interface ReportService {
	
	public ByteArrayInputStream downalodExcel();
	
	public List<Customer> downloadPdf();
	
	public List<Customer> searchCoustomers(String planeName, String status);

}
