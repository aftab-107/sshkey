package com.OneToMany.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OneToMany.Entity.Faculty;
import com.OneToMany.Entity.Student;
import com.OneToMany.Repository.FacultyRepo;
import com.OneToMany.Repository.StudentRepo;

@Service
public class UniversityService {
	@Autowired
	private StudentRepo studentrepo;
	@Autowired 
	private FacultyRepo facultyrepo;
	
	// student operation
	
	public List<Student> findAll(Student student){
		return studentrepo.findAll();
	}
	
	public Student StudentSave(Student student) {
		return studentrepo.save(student);
	}
	
	//Faculty operation
	
	public List<Faculty> findAll(Faculty faculty){
		return facultyrepo.findAll();
	}
	
	public Faculty FacultySave(Faculty faculty) {
		return facultyrepo.save(faculty);
	}

}
