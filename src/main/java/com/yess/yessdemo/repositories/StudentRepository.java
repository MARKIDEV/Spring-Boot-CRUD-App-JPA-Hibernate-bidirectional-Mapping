package com.yess.yessdemo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.RequestParam;

import com.yess.yessdemo.models.Klass;
import com.yess.yessdemo.models.Student;

@RepositoryRestResource
public interface StudentRepository extends JpaRepository<Student, Long> {
	@RestResource(path = "/byFirstName")
	public List<Student> findByFirstNameContains(@RequestParam String xx);
//
//	@RestResource(path = "/byKlassId")
//	public List<Student> findByKlass_id(@RequestParam Long mc);
	@Query("SELECT s FROM STUDENT s WHERE klass_id = ?1")
   public List<Student> findByKlass_id(Long klass_id);

}