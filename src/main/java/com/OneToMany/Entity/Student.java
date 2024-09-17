package com.OneToMany.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
public class Student {
	@Id 
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Sid;
	private String Sname;
	private String Subject;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fid",nullable = false)

	private Faculty faculty;

	public long getSid() {
		return Sid;
	}

	public void setSid(long sid) {
		Sid = sid;
	}

	public String getSname() {
		return Sname;
	}

	public void setSname(String sname) {
		Sname = sname;
	}

	public String getSubject() {
		return Subject;
	}

	public void setSubject(String subject) {
		Subject = subject;
	}

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}
	

}
