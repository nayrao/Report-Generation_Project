package com.example.report.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.example.report.entity.CitizenPlan;
import com.example.report.repo.ReportRepository;

@Component
public class DataInsertUsinRunInSpringBoot implements ApplicationRunner{

	@Autowired
	private ReportRepository repository;
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		CitizenPlan plan=new CitizenPlan();
		plan.setPlanName("LIC");
		plan.setPlanStatus("Approved");
		plan.setGender("MALE");
		plan.setCname("Raja");
		plan.setCemail("rajarao1284@gmail.com");
		plan.setSsn(358756l);
		plan.setPhno(9739142977l);
		
		CitizenPlan plan1=new CitizenPlan();
		plan1.setPlanName("BAJAJ");
		plan1.setPlanStatus("Denied");
		plan1.setGender("FEMALE");
		plan1.setCname("Rani");
		plan1.setCemail("ranim1284@gmail.com");
		plan1.setSsn(358785l);
		plan1.setPhno(98865433l);
		
		CitizenPlan plan2=new CitizenPlan();
		plan2.setPlanName("BANK");
		plan2.setPlanStatus("Denied");
		plan2.setGender("FEMALE");
		plan2.setCname("ramya");
		plan2.setCemail("ramya1284@gmail.com");
		plan2.setSsn(35873425l);
		plan2.setPhno(9886543897l);
		
		CitizenPlan plan3=new CitizenPlan();
		plan3.setPlanName("LIC");
		plan3.setPlanStatus("Approved");
		plan3.setGender("MALE");
		plan3.setCname("Suri");
		plan3.setCemail("surin1284@gmail.com");
		plan3.setSsn(358756l);
		plan3.setPhno(9739142977l);
		
		List<CitizenPlan> asList = Arrays.asList(plan,plan1,plan2,plan3);
		repository.saveAll(asList);
		
	}

}
