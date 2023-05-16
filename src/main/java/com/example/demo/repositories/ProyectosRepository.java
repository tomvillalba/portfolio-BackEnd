package com.example.demo.repositories;

import com.example.demo.models.ProyectosModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyectosRepository extends CrudRepository<ProyectosModel, Integer> {

}
