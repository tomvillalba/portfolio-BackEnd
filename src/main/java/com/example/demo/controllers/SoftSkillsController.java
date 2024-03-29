package com.example.demo.controllers;

import com.example.demo.models.SoftSkillsModel;
import com.example.demo.services.SoftSkillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<RespuestaEliminar> eliminarPorId(@PathVariable("id") Integer id) {
        boolean ok = this.softSkillsService.eliminarSoftSkill(id);
        if (ok) {
            RespuestaEliminar respuesta = new RespuestaEliminar("Se eliminó la softskill con id " + id);
            return ResponseEntity.ok(respuesta);
        } else {
            RespuestaEliminar respuesta = new RespuestaEliminar("No se pudo eliminar la softskill con id " + id);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(respuesta);
        }
    }

}
