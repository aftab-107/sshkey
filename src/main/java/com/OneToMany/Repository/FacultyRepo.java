package com.OneToMany.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.OneToMany.Entity.Faculty;
@Repository
public interface FacultyRepo extends JpaRepository<Faculty ,Long>{

}
