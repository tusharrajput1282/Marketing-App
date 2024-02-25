package com.marketingapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.marketingapp.dto.RegistrationDto;
import com.marketingapp.entity.Registration;
import com.marketingapp.model.RegistrationService;
import com.marketingapp.util.EmailService;

@Controller									//it creates the handler methods[doget,dopost methods]
public class RegistrationController {
	
	@Autowired
	private RegistrationService registrationService;
	
	@Autowired
	private EmailService emailService;
	
	@RequestMapping("/views")               //https://localhost:8080/views, this annotation works as @WebServlet where if we put this link in browser, it will call that method only, where its redirecting to the jsp page known as "create_lead"
	public String viewRegistrationPage() {
		return "create_registration";
	}
	
// 1st Approach
//	@RequestMapping("/saveReg")
//	public String saveRegistration(Registration registration) {
//		registrationService.saveRegistration(registration);        //here its called the service layer's .saveRegistration
//		
//		return "create_registration";
//	}
	
	
// 2nd Approach
//	@RequestMapping("/saveReg")
//	public String saveRegistration(
//				@RequestParam("firstName") String firstName,      	//@RequestParam-it helps to take <form> data and to store in a refernce variable which is String firstName; here
//				@RequestParam("lastName") String lastName,
//				@RequestParam("email") String email,
//				@RequestParam("mobile") Long mobile
//			) {
//				Registration reg = new Registration();
//				reg.setFirstName(firstName);
//				reg.setLastName(lastName);
//				reg.setEmail(email);
//				reg.setMobile(mobile);
//				
//				registrationService.saveRegistration(reg);
//				
//				return "create_registration";
//	}
	
	
// 3rd Approach
	@RequestMapping("/saveReg")											//DTO- Data Transfer Object
	public String saveRegistration(RegistrationDto dto, Model model) {
		Registration reg = new Registration();
		reg.setFirstName(dto.getFirstName());
		reg.setLastName(dto.getLastName());
		reg.setEmail(dto.getEmail());
		reg.setMobile(dto.getMobile());
		
		registrationService.saveRegistration(reg);
		
		model.addAttribute("msg","Record is Saved!!");
		
		emailService.sendEmail(dto.getEmail(), "Welcome", "Test");
		
		return "create_registration";
	}
	
	
	@RequestMapping("/getAllReg")
	public String getAllRegistrations(Model model) {			//it helps to read all the data into your "list_registration.jsp" page
		List<Registration> registrations = registrationService.getAllRegistrations();	
		model.addAttribute("registrations", registrations);		//model att. helps to find pass the data from one servlet to another
		
		return "list_registrations";
	}
	
	
	@RequestMapping("/delete")
	public String deleteRegistration(@RequestParam long id, Model model) {	//here we recieving the id by the "list_registration.jsp" page
		registrationService.deleteById(id);
		List<Registration> registrations = registrationService.getAllRegistrations();
		model.addAttribute("registrations", registrations);
		
		return "list_registrations";
	}
	
	
	
	@RequestMapping("/update")
	public String updateViewPage(@RequestParam long id, ModelMap model) {		    //when u click on update on that list than its id get picked up and gets recieved using @RequestParam
		Registration registration = registrationService.getRegistrationById(id);    //Optional is a java 8 feature which helps to remove the "Null Pointer Exception"
		model.addAttribute("registration", registration);
		
		return "update_registration";
	}
	
	
	@RequestMapping("/updateReg")
	public String updateRegistration(RegistrationDto dto, ModelMap model) {
		Registration reg = new Registration();
		reg.setId(dto.getId());
		reg.setFirstName(dto.getFirstName());
		reg.setLastName(dto.getLastName());
		reg.setEmail(dto.getEmail());
		reg.setMobile(dto.getMobile());
		
		registrationService.saveUpdatedRegistration(reg);
		
		List<Registration> registrations = registrationService.getAllRegistrations();
		model.addAttribute("registrations", registrations);
		
		return "list_registrations";
	}
	
}
