package com.yess.yessdemo;

import java.util.List;
import java.util.Optional;

//import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yess.yessdemo.models.Department;
import com.yess.yessdemo.models.Klass;
import com.yess.yessdemo.models.Student;
import com.yess.yessdemo.repositories.DepartmentRepository;
import com.yess.yessdemo.repositories.KlassRepository;
import com.yess.yessdemo.repositories.StudentRepository;
 
@SpringBootApplication

public class YessdemoApplication  {
	@Autowired
	private DepartmentRepository departmentRepository;
	@Autowired
	private KlassRepository klassRepository;
	@Autowired
	private StudentRepository studentRepository;
	public static void main(String[] args) {
		SpringApplication.run(YessdemoApplication.class, args);
	}
	
	 @Bean
	 CommandLineRunner start (RepositoryRestConfiguration restConfiguration ) {
	  return args ->{
		  restConfiguration.exposeIdsFor(Student.class);
		  Department d1= departmentRepository.save(new Department(null,"scientific","best one",null));
		  Department d2= departmentRepository.save(new Department(null,"litteral","primordial",null));
		Klass k1= klassRepository.save(new Klass(null,"primairy","kids",null,d1));
		Klass k2= klassRepository.save(new Klass(null,"secondary","les petits",null,d2));
		  studentRepository.save(new Student(null,"Ikram","Belhouchet",k1));
		  studentRepository.save(new Student(null,"Ibtihel","Bhhhhhh",k1));
		  studentRepository.save(new Student(null,"imen","Bhhhhhh",k1));
		  studentRepository.save(new Student(null,"ameni","Bilhaj",k2));
		  studentRepository.save(new Student(null,"dorra","Bilhaj",k2));
		  studentRepository.save(new Student(null,"ahmed","Bilhaj",k2));
		  studentRepository.save(new Student(null,"anis","Bilhaj",k2));
		  studentRepository.findAll().forEach(st->{
			  System.out.println(st.getFirstName());
			  
			  
				
			
//
//		        long id2 = 5L;
//		        Optional <Student> optional = studentRepository.findById(id2);
//
//		        if (optional.isPresent()) {
//		            System.out.println(optional.get());
//		        } else {
//		            System.out.printf("No employee found with id %d%n", id2);
//		        }
//
//		        // get list of students
//		        List <Student> students = studentRepository.findAll();
//		        students.forEach(student -> System.out.println (student.getFirstName()));
//
//		        
		  });
	  };
	  
}
}
