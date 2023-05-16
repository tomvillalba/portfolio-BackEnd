package com.example.demo.repositories;

import com.example.demo.models.IdiomasModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdiomasRepository extends CrudRepository<IdiomasModel, Integer> {

}
