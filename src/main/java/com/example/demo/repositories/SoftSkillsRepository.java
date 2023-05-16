package com.example.demo.repositories;

import com.example.demo.models.SoftSkillsModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoftSkillsRepository extends CrudRepository<SoftSkillsModel, Integer> {

}
