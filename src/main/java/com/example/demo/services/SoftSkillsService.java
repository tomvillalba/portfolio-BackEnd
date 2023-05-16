package com.example.demo.services;

import com.example.demo.models.SoftSkillsModel;
import com.example.demo.repositories.SoftSkillsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class SoftSkillsService {

    @Autowired
    SoftSkillsRepository softSkillsRepository;

    public ArrayList<SoftSkillsModel> obtenerSoftSkills() {
        return (ArrayList<SoftSkillsModel>) softSkillsRepository.findAll();
    }

    public SoftSkillsModel guardarSoftSkill(SoftSkillsModel softSkill) {
        return softSkillsRepository.save(softSkill);
    }

    public boolean eliminarSoftSkill(Integer id) {
        try {
            softSkillsRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

}
