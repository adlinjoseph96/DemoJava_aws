package com.spring.MicroservicesProject.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="employee_details")
public class Employee {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "id")
    public int id;
	@Column(name = "name")
    public String name;
	@Column(name = "address")
    public String address;
	@Column(name = "phone")
    public String phone;
	@Column(name = "project")
    public String project;
	
	 @OneToOne(mappedBy = "employee_details")
	
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id=id;
	}
	
	
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name=name;
	}
	
	public String getAddress()
	{
		return address;
	}
	public void setAddress(String address)
	{
		this.address=address;
	}
	
	public String getPhone()
	{
		return phone;
	}
	public void setPhone(String phone)
	{
		this.phone=phone;
	}
	
	public String getProject()
	{
		return project;
	}
	public void setProject(String project)
	{
		this.project=project;
	}
	
	
	

}



