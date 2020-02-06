package com.yess.yessdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.yess.yessdemo.models.Department;
@RepositoryRestResource
public interface DepartmentRepository extends JpaRepository <Department, Long> {

	

}
