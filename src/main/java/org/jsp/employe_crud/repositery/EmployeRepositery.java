package org.jsp.employe_crud.repositery;

import org.jsp.employe_crud.dto.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeRepositery  extends JpaRepository<Employe, Integer>{
    @Query(value = "select * from Employe e where e.name=:name",nativeQuery = true)
	Employe fetchByName(String name);

}
