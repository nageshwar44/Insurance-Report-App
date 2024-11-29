package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.apache.catalina.filters.ExpiresFilter.XHttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.CitizenPlan;
import com.example.demo.request.SearchRequest;
import com.example.demo.serviceImpl.CitizenServiceImpl;

import jakarta.servlet.http.HttpServletResponse;

@Controller
//@RequestMapping("/app")
public class CitizenController {
	
	@Autowired
	private CitizenServiceImpl service;
	
	@GetMapping("/pdf")
	public void pdfExport(HttpServletResponse response) throws Exception{
		response.setContentType("application/pdf");
		response.addHeader("Content-Dispotion", "attachment; filename=plans.pdf");
		service.exportPdf(response);
	}
	
	
	@GetMapping("/excel")
	public void excelExport (HttpServletResponse response,@ModelAttribute SearchRequest request) throws Exception{
		response.setContentType("application/vnd.ms-excel");
		response.addHeader("Content-Dispotion", "attachment; filename=plans.xls");
		service.exportExcel(response, request);
	}
	
	@PostMapping ("/search")
	public String handleSearch(@ModelAttribute ("request") SearchRequest request, Model model) {
		System.out.println(request);
	List<CitizenPlan> plans=service.search(request);
	model.addAttribute("plans", plans); 
	model.addAttribute("request",request);
	for (CitizenPlan item : plans) { System.out.println(item); }
		
		init(model);
		return "index";
	}
	
	 @GetMapping("/")
	    public String indexPage(Model model ) {
			//invoke service method
			model.addAttribute("search", new SearchRequest());
			
			    init(model);
	        return "index"; // This should correspond to /WEB-INF/jsp/index.jsp
	    }
	
	private void init (Model model) {
		model.addAttribute("planNames", service.getPlanName());
		model.addAttribute("planStatus", service.getPlanStatus());	
	} 
	
	
}
