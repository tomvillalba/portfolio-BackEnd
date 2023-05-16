package com.example.demo.repositories;

import com.example.demo.models.EducacionModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducacionRepository extends CrudRepository<EducacionModel, Integer> {

}

