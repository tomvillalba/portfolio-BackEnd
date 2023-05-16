package com.example.demo.controllers;

import com.example.demo.models.SoftSkillsModel;
import com.example.demo.services.SoftSkillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/softskills")
public class SoftSkillsController {

    @Autowired
    SoftSkillsService softSkillsService;

    @GetMapping()
    public ArrayList<SoftSkillsModel> obtenerSoftSkills() {
        return softSkillsService.obtenerSoftSkills();
    }

    @PostMapping()
    public SoftSkillsModel guardarSoftSkill(@RequestBody SoftSkillsModel softSkill) {
        return this.softSkillsService.guardarSoftSkill(softSkill);
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Integer id) {
        boolean ok = this.softSkillsService.eliminarSoftSkill(id);
        if (ok) {
            return "Se eliminó el soft skill con id " + id;
        } else {
            return "No se pudo eliminar el soft skill con id " + id;
        }
    }

}
