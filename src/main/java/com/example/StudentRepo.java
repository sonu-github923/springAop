package com.example;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface StudentRepo extends CrudRepository<studententity, Integer>

{


	List<studententity> findByemailid(String email);

}
