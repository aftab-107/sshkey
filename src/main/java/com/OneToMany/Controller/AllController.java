package com.OneToMany.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.OneToMany.Entity.Faculty;
import com.OneToMany.Entity.Student;
import com.OneToMany.Service.UniversityService;

@RestController
@RequestMapping("/")
public class AllController {
	
	@Autowired
	private UniversityService uniService;
	
	//student operation
	@GetMapping("/student")
	public List<Student> findAll(Student student){
		return uniService.findAll(student);
	}
	
	@PostMapping("/student")
	public Student SaveStudent(@RequestBody Student student) {
		return uniService.StudentSave(student);
	}
	
	//faculty operation
	@GetMapping("/faculty")
	public List<Faculty> findAll(Faculty faculty){
		return uniService.findAll(faculty);
	}
	
	@PostMapping("/faculty")
	public Faculty SaveFaculty(@RequestBody Faculty faculty) {
		return uniService.FacultySave(faculty);
	}

}
