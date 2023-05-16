package com.example.demo.services;

import com.example.demo.models.HardSkillsModel;
import com.example.demo.repositories.HardSkillsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class HardSkillsService {

    @Autowired
    HardSkillsRepository hardSkillsRepository;

    public ArrayList<HardSkillsModel> obtenerHardSkills() {
        return (ArrayList<HardSkillsModel>) hardSkillsRepository.findAll();
    }

    public HardSkillsModel guardarHardSkill(HardSkillsModel hardSkill) {
        return hardSkillsRepository.save(hardSkill);
    }

    public boolean eliminarHardSkill(Integer id) {
        try {
            hardSkillsRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }
}
