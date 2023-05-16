package com.example.demo.repositories;

import com.example.demo.models.InformacionPersonalModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InformacionPersonalRepository extends CrudRepository<InformacionPersonalModel, Long> {

}
