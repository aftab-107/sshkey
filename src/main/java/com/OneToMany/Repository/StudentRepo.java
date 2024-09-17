package com.OneToMany.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.OneToMany.Entity.Student;
@Repository
public interface StudentRepo extends JpaRepository<Student , Long> {

}
