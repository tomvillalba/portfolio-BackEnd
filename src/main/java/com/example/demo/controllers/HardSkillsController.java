package com.example.demo.controllers;

import com.example.demo.models.HardSkillsModel;
import com.example.demo.services.HardSkillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/hardskills")
public class HardSkillsController {

    @Autowired
    HardSkillsService hardSkillsService;

    @GetMapping()
    public ArrayList<HardSkillsModel> obtenerHardSkills() {
        return hardSkillsService.obtenerHardSkills();
    }

    @PostMapping()
    public HardSkillsModel guardarHardSkill(@RequestBody HardSkillsModel hardSkill) {
        return this.hardSkillsService.guardarHardSkill(hardSkill);
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Integer id) {
        boolean ok = this.hardSkillsService.eliminarHardSkill(id);
        if (ok) {
            return "Se eliminó el hard skill con id " + id;
        } else {
            return "No se pudo eliminar el hard skill con id " + id;
        }
    }
}
