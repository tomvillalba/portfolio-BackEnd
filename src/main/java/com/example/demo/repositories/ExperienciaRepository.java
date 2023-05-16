package com.example.demo.repositories;

import com.example.demo.models.ExperienciaModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienciaRepository extends CrudRepository<ExperienciaModel, Integer> {

}
