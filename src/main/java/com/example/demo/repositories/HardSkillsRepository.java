package com.example.demo.repositories;

import com.example.demo.models.HardSkillsModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HardSkillsRepository extends CrudRepository<HardSkillsModel, Integer> {

}
