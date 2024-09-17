package com.OneToMany.Entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Faculty {
	@Id 
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private long Fid;
	private String Fname;
	private String Salary;
	
	@OneToMany(mappedBy ="faculty" ,cascade = CascadeType.ALL)
	
	private List<Student> student;

	public long getFid() {
		return Fid;
	}

	public void setFid(long fid) {
		Fid = fid;
	}

	public String getFname() {
		return Fname;
	}

	public void setFname(String fname) {
		Fname = fname;
	}

	public String getSalary() {
		return Salary;
	}

	public void setSalary(String salary) {
		Salary = salary;
	}

	public List<Student> getStudent() {
		return student;
	}

	public void setStudent(List<Student> student) {
		this.student = student;
	}

	

}
