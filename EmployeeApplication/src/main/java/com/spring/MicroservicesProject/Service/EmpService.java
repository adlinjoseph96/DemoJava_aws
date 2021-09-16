package com.spring.MicroservicesProject.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.spring.MicroservicesProject.Dao.EmpDao;
import com.spring.MicroservicesProject.Model.Employee;
//import com.spring.MicroservicesProject.Repository.EmpRepository;


@Service
public class EmpService {
	
	
	
	@Autowired
	private EmpDao dao;
	public List<Employee>getEmployeeData(){
		List<Employee> empList=dao.getEmployeeData();
		return empList;
	}
	
	public Employee getEmployeeDataBasedOnId(int id) {
		List<Employee>empList=dao.getEmployeeDataBasedOnId(id);
		return empList.get(0);
	}
	
public boolean addEmployeeToDb(Employee emp) {
	boolean status=dao.addEmployeeToDb(emp);
	return status;
}
public boolean deleteEmployeeFromDb(int id) {
	boolean status=dao.deleteEmployeefromDb(id);
	return status;
}


	

}
