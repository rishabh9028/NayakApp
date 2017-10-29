package com.cg.customer.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.customer.model.Customer;
import com.cg.customer.service.ICustomerService;

@Controller
public class customerController {

	@Autowired
	ICustomerService service;
	@RequestMapping("/index")
	public String firtsPage(){
		return "index";
	}
	
	
	@RequestMapping("/start")
	public String goToStart(Model model){
		model.addAttribute("bean",new Customer());
		return "customerRegForm";
	}
	
	@RequestMapping("/reg")
	public ModelAndView registration(@ModelAttribute("bean") @Valid Customer cust,BindingResult result){
		if(result.hasErrors())
		{
			 
			 return new ModelAndView("customerRegForm");
		}
		service.addDetails(cust);
		return new ModelAndView("customerSuccess", "k", cust);
	}
	
	
	
	/*
	@RequestMapping("/goFind")
	public String goToFind(){
		return "custIdFind";
	}*/
	
	@RequestMapping("/find")
	public ModelAndView findById(@RequestParam("custId") int custId){
		
		Customer cust = service.retrieveById(custId);
		return new ModelAndView("customerSuccess", "k", cust);
	}
	
	@RequestMapping("/toFind")
	public ModelAndView getIds(){
		
		List<Integer> idList= service.retrieveIds();
		return new ModelAndView("custIdFind", "idList", idList);
	}
	
	@RequestMapping("/goFindAll")
	public ModelAndView findAll(){
		
		List<Customer> custList = service.retrieveDetails();
		return new ModelAndView("customerListSuccess", "list", custList);
	}
	
	@RequestMapping("/remove")
	public ModelAndView goToDelete()
	{
		List<Integer> idList= service.retrieveIds();
		return new ModelAndView("Removecust", "idList", idList);
	}  
	
	
	@RequestMapping("/delete")
	public String deleteById(@RequestParam("custId") int cId)
	{
			service.deleteCustomer(cId);
		
		return "RemoveResult";
	}
	

	
	@RequestMapping("/Update")
	public ModelAndView goToUpdate(){
		List<Integer> custId=service.retrieveIds();
		return new ModelAndView("CustUpdateId","custId",custId);
	}

	@RequestMapping("/update")
	public String updateById(@RequestParam("custId") int custId,Model m){
		Customer cust = service.retrieveById(custId);
		System.out.println(cust);
		m.addAttribute("customer", cust);
		return "UpdateForm";
	}
	@RequestMapping("/doUpdation")
	public String updateDetails(@ModelAttribute("customer") @Valid Customer cust,BindingResult result, Model model){
		
		if(result.hasErrors())
		{
			return "UpdateForm";
		}
		else{
			Customer customer = service.update(cust);
			model.addAttribute("k", customer);
			return "UpdateSuccess";
		}	
	}
	
	@RequestMapping("/Back")
	public String goToIndex(){
		return "index";
	}
}
	/*@RequestMapping("/goDelete")
	public String goToDelete(){
		return "custIdDelete";
	}
	
	@RequestMapping("/delete")
	public String deleteById(@RequestParam("custId") int custId){
		Customer cust = service.retrieveById(custId);
		service.deleteDetails(cust);
		return "deleteCust";
	}*/
	

	
	
