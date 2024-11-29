package com.example.demo.runner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.example.demo.entity.CitizenPlan;
import com.example.demo.repo.CitizenPlanRepository;

@Component
public class DataLoader  implements ApplicationRunner{

@Autowired
private CitizenPlanRepository repo;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		repo.deleteAll();
		

		//cash plan data
				CitizenPlan c1=new CitizenPlan();
				c1.setCitizenName("john");
				c1.setGender("male");
				c1.setPlanName("cash");
				c1.setPlanStatus("Approved");
				c1.setPlanStartDate(LocalDate.now());
				c1.setPlanEndDate(LocalDate.now().plusMonths(6));
				c1.setBenifitAmt(5000.00);
		
				CitizenPlan c2=new CitizenPlan();
				c2.setCitizenName("Magan");
				c2.setGender("male");
				c2.setPlanName("cash");
				c2.setPlanStatus("Denied");
				c2.setDenielReason("rental");
				
				CitizenPlan c3=new CitizenPlan();
				c3.setCitizenName("hurble");
				c3.setGender("male");
				c3.setPlanName("cash");
				c3.setPlanStatus("terminated");
				c3.setTerminatedDate(LocalDate.now());
				c3.setTerminationRsn("Emplyeed");
				c3.setPlanStartDate(LocalDate.now().minusMonths(4));
				c3.setPlanEndDate(LocalDate.now().plusMonths(6));
				
				//Food plan data
				CitizenPlan c4=new CitizenPlan();
				c4.setCitizenName("marcel");
				c4.setGender("Male");
				c4.setPlanName("Food");
				c4.setPlanStatus("Approved");
				c4.setPlanStartDate(LocalDate.now());
				c4.setPlanEndDate(LocalDate.now().plusMonths(6));
				c4.setBenifitAmt(4008.00);
				
				CitizenPlan c5=new CitizenPlan();
				c5.setCitizenName("fujan");
				c5.setGender("male");
				c5.setPlanName("Food");
				c5.setPlanStatus("Denied");
				c5.setDenielReason("Property Income");
				
				CitizenPlan c6=new CitizenPlan();
				c6.setCitizenName("orlen");
				c6.setGender("male");
				c6.setPlanName("Food");
				c6.setPlanStatus("terminated");
				c6.setTerminatedDate(LocalDate.now());
				c6.setTerminationRsn("Emplyeed");
				c6.setPlanStartDate(LocalDate.now().minusMonths(4));
				c6.setPlanEndDate(LocalDate.now().plusMonths(6));
				
				//Medical plan data
				CitizenPlan c7=new CitizenPlan();
				c7.setCitizenName("ket");
				c7.setGender("Female");
				c7.setPlanName("Medical"); 
				c7.setPlanStatus("Approved");
				c7.setPlanStartDate(LocalDate.now());
				c7.setPlanEndDate(LocalDate.now().plusMonths(6));
				c7.setBenifitAmt(4009.00);
				
				CitizenPlan c8=new CitizenPlan();
				c8.setCitizenName("manjhi");
				c8.setGender("male");
				c8.setPlanName("Medical");
				c8.setPlanStatus("Denied");
				c8.setDenielReason("Property Income incomplete");
				
				CitizenPlan c9=new CitizenPlan();
				c9.setCitizenName("mufasir");
				c9.setGender("male");
				c9.setPlanName("Medical");
				c9.setPlanStatus("terminated");
				c9.setTerminatedDate(LocalDate.now());
				c9.setTerminationRsn("Emplyeed");
				c9.setPlanStartDate(LocalDate.now().minusMonths(4));
				c9.setPlanEndDate(LocalDate.now().plusMonths(6));
				
				//Employment plan
				CitizenPlan c10=new CitizenPlan();
				c10.setCitizenName("urmila");
				c10.setGender("Female");
				c10.setPlanName("Employment"); 
				c10.setPlanStatus("Approved");
				c10.setPlanStartDate(LocalDate.now());
				c10.setPlanEndDate(LocalDate.now().plusMonths(6));
				c10.setBenifitAmt(7000.00);
				
				CitizenPlan c11=new CitizenPlan();
				c11.setCitizenName("jahan");
				c11.setGender("male");
				c11.setPlanName("Employment");
				c11.setPlanStatus("Denied");
				c11.setDenielReason("Property Income incomplete");
				
				CitizenPlan c12=new CitizenPlan();
				c12.setCitizenName("beast");
				c12.setGender("male");
				c12.setPlanName("Employment");
				c12.setPlanStatus("terminated");
				c12.setTerminatedDate(LocalDate.now());
				c12.setTerminationRsn("Gov Job");
				c12.setPlanStartDate(LocalDate.now().minusMonths(4));
				c12.setPlanEndDate(LocalDate.now().plusMonths(6));
				
			List<CitizenPlan> list=Arrays.asList(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12 );
			
			
			repo.saveAll(list);
				
	}
	

}
