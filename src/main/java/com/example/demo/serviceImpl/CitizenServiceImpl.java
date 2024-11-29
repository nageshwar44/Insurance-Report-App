package com.example.demo.serviceImpl;

import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.example.demo.entity.CitizenPlan;
import com.example.demo.repo.CitizenPlanRepository;
import com.example.demo.request.SearchRequest;
import com.example.demo.service.CitizenService;
import com.example.demo.utils.EmailUtil;
import com.example.demo.utils.ExcelGenerator;
import com.example.demo.utils.PdfGenerator;


import jakarta.servlet.http.HttpServletResponse;

@Service
public class CitizenServiceImpl implements CitizenService {

	@Autowired
	private CitizenPlanRepository planRepo;

	@Autowired
	private ExcelGenerator excelGenerator;

	@Autowired
	private PdfGenerator pdfGenerator;
	
	@Autowired
	private EmailUtil emailUtil;

	@Override
	public List<String> getPlanName() {
		return planRepo.getPlanName();
	}

	@Override
	public List<String> getPlanStatus() {
		return planRepo.getPlanStatus();
	}

	@Override
	public List<CitizenPlan> search(SearchRequest request) {
		CitizenPlan entity = new CitizenPlan();
		if (null != request.getPlanName() && !"".equals(request.getPlanName())) {
			entity.setPlanName(request.getPlanName());
		}
		if (null != request.getPlanStatus() && !"".equals(request.getPlanStatus())) {
			entity.setPlanStatus(request.getPlanStatus());
		}
		if (null != request.getGender() && !"".equals(request.getGender())) {
			entity.setGender(request.getGender());
		}
		return planRepo.findAll(Example.of(entity));
	}

	@Override
	public boolean exportExcel(HttpServletResponse response,SearchRequest request) throws Exception {
		File f=new File("plans.xls");
		List<CitizenPlan> plans = search(request);
		excelGenerator.genarate(response, plans,f);
		String subject="Test mail";
		String body="<h1>Test Body</h1>";
		String to="chavannageshwar44@gmail.com";
		System.out.println("Sending email to: " + to);
		
		if (to == null || to.isEmpty()) { throw new IllegalArgumentException("Recipient email address is missing"); }
		emailUtil.sendEmail(subject, body, to,f);
		f.delete();

		return true;
	}

	@Override
	public boolean exportPdf(HttpServletResponse response) throws Exception {
		File f=new File("plans.pdf");

		List<CitizenPlan> plans = planRepo.findAll();
		pdfGenerator.genarater(response, plans,f);
		String subject="Test mail";
		String body="<h1>Test Body</h1>";
		String to="nbchavhan8928@gmail.com";
		System.out.println("Sending email to: " + to);
		emailUtil.sendEmail(subject, body, to,f);
		f.delete();
		return true;
	}
}
