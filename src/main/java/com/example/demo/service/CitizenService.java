package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.CitizenPlan;
import com.example.demo.request.SearchRequest;

import jakarta.servlet.http.HttpServletResponse;
@Service
public interface CitizenService {
	public List<String> getPlanName();
	public List<String> getPlanStatus();
	public List<CitizenPlan> search(SearchRequest request);
	
	public boolean exportExcel(HttpServletResponse response,SearchRequest request) throws Exception;
	public boolean exportPdf(HttpServletResponse response) throws Exception;

	

}
