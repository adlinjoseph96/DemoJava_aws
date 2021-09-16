package com.spring.MicroservicesProject.Controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.spring.MicroservicesProject.Model.Employee;
import com.spring.MicroservicesProject.Service.EmpService;


@RestController
@RequestMapping("/employee")
public class EmpController {
	
	@Autowired
	private EmpService service;
	
	
	@RequestMapping(value="/getEmployeeData",method=RequestMethod.GET)
	public List<Employee>getEmployeeData(){
		
		List<Employee> li=service.getEmployeeData();
		return li;
		
		
	}
		
	@RequestMapping(value="/postEmployeeData",method=RequestMethod.POST , consumes =MediaType.APPLICATION_JSON_VALUE , produces=MediaType.APPLICATION_JSON_VALUE)
	
	public Employee employeePostCall(@RequestBody Employee employee) {
		if(Objects.isNull(employee.getId())||(employee.getId()==0)) {
			throw new IllegalArgumentException("Invalid Employee id");
			
		}
		
		Employee employeeObj=service.getEmployeeDataBasedOnId(employee.getId());
		return employeeObj;
	}
	
	
	
	@RequestMapping(value="/putEmployeeData",method= RequestMethod.PUT , consumes= MediaType.APPLICATION_JSON_VALUE)
	public String addEmployeeToDb(@RequestBody Employee emp) {
		boolean status=service.addEmployeeToDb(emp);
		
		if(status==true) {
			return "Employee addedd successfully";
		}
		else {
			return "Failed to add data to Employee";
		}
		
	}
		
		
//		boolean status=service.addEmployeeToDb(emp);
//		if(status) {
//			return "Employee added successfully";
//		}
//		else {
//			return "Sorry update failed";
//		}
//	}
	
	
	@RequestMapping(value="/deleteEmployeeData/{id}",method=RequestMethod.DELETE)
	public String deleteEmployeeData(@PathVariable("id") int id){
		if(Objects.isNull(id)||id==0){
			throw new IllegalArgumentException("id is req");
		}
		
		else {
		
		boolean status=service.deleteEmployeeFromDb(id);
		
			
		if(status) {
			return "Employee data successfully deleted";
		}
		else {
			return "Failed to delete data";
		}
		}
		
	
	}


}
