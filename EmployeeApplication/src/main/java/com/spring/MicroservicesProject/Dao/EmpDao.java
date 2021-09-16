package com.spring.MicroservicesProject.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;
import com.spring.MicroservicesProject.Model.Employee;


@Component
public class EmpDao {
	@Autowired
	private JdbcTemplate template;
	public List<Employee>getEmployeeData(){
		String sql="select* from employee_details";
		List<Employee> employeeList=template.query(sql, new ResultSetExtractor<List<Employee>>() {
			

			@Override
			public List<Employee>extractData(ResultSet rs)throws SQLException,DataAccessException{
				
				List<Employee> list=new ArrayList<Employee>();
				while(rs.next()) {
					Employee employee=new Employee();
					employee.setId(rs.getInt("id"));
					employee.setName(rs.getString("name"));
					employee.setAddress(rs.getString("address"));
					employee.setPhone(rs.getString("phone"));
					employee.setProject(rs.getString("project"));
					list.add(employee);
					
				}
				return list;
			}
		
		});
		return employeeList;
	}
		
		public List<Employee>getEmployeeDataBasedOnId1(int id){
//			String sql="select * from employee_details  where id="+id;
			
			String sql="Select * from employee_details,employee_leaves where employee_details.id="+id+"and employee_leaves.id=data.employee_details.id";
			
			List<Employee> employeeList=template.query(sql, new ResultSetExtractor<List<Employee>>() {
				
				@Override
				public List<Employee> extractData(ResultSet rs)throws SQLException,DataAccessException{
					
					List<Employee> list =new ArrayList<Employee>();
					while(rs.next()) {
						
						Employee employee = new Employee();
						employee.setId(rs.getInt("id"));
						employee.setName(rs.getString("name"));
						employee.setAddress(rs.getString("address"));
						employee.setPhone(rs.getString("phone"));
						employee.setProject(rs.getString("project"));
						list.add(employee);
					}
					return list;
					
				}
				
				
			});
			
			employeeList.stream().forEach(employee->{
				System.out.println(employee.getId()+"-"+employee.getName());
			});
			
			return employeeList;
			
				
		}
		
		
		public List<Employee>getEmployeeDataBasedOnId(int id){
			
			String sql="select * from employee_details where id="+id;
			List<Employee> employeeList=template.query(sql, new ResultSetExtractor<List<Employee>>() {
				
				@Override
				public List<Employee>extractData(ResultSet rs)throws SQLException,DataAccessException{
					
					List<Employee> list =new ArrayList<Employee>();
					while(rs.next()) {
						Employee employee=new Employee();
						employee.setId(rs.getInt("id"));
						employee.setName(rs.getString("name"));
						employee.setAddress(rs.getString("address"));
						employee.setPhone(rs.getString("phone"));
						employee.setProject(rs.getString("project"));
						
						list.add(employee);
					}
					return list;
				}
				
				
				
				
				
				
			});
			
			return employeeList;
		}
		
		
		public boolean addEmployeeToDb(Employee emp) {
			
			boolean status=false;
			
			try {
				
				String sql="insert into employee_details(id,name,address,phone,project) values("+emp.getId()+",'"+emp.getName()+"','"+emp.getAddress()+"','"+emp.getPhone()+"','"+emp.getProject()+"')";
				template.execute(sql);
				status=true;
				//return status;
			}catch(Exception e) {
				status=false;
				//return status;
			}
			return status;
		}
		
		
		
	public boolean deleteEmployeefromDb(int id) {
			
			boolean status=false;
			
			try {
				
				String sql="delete from employee_details where id="+id;
				template.execute(sql);
				status=true;
				
			}
			
			catch(Exception e) {
				status=false;
				
			}
			return status;
		}
		
		
		
			
		}


