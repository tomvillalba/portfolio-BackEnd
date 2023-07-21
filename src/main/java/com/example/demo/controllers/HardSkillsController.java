package com.example.demo.controllers;

import com.example.demo.models.HardSkillsModel;
import com.example.demo.services.HardSkillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<RespuestaEliminar> eliminarPorId(@PathVariable("id") Integer id) {
        boolean ok = this.hardSkillsService.eliminarHardSkill(id);
        if (ok) {
            RespuestaEliminar respuesta = new RespuestaEliminar("Se eliminó el hardskill con id " + id);
            return ResponseEntity.ok(respuesta);
        } else {
            RespuestaEliminar respuesta = new RespuestaEliminar("No se pudo eliminar el hardskill con id " + id);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(respuesta);
        }
    }
}
