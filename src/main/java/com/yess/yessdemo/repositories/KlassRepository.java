package com.yess.yessdemo.repositories;






//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import com.yess.yessdemo.models.Klass;



@RepositoryRestResource
public interface KlassRepository extends JpaRepository<Klass, Long> {

}
