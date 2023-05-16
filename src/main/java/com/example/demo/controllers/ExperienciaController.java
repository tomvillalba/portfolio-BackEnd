package com.example.demo.controllers;

import com.example.demo.models.ExperienciaModel;
import com.example.demo.services.ExperienciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/experiencia")
public class ExperienciaController {

    @Autowired
    ExperienciaService experienciaService;

    @GetMapping()
    public ArrayList<ExperienciaModel> obtenerExperiencias() {
        return experienciaService.obtenerExperiencias();
    }

    @PostMapping()
    public ExperienciaModel guardarExperiencia(@RequestBody ExperienciaModel experiencia) {
        return this.experienciaService.guardarExperiencia(experiencia);
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Integer id) {
        boolean ok = this.experienciaService.eliminarExperiencia(id);
        if (ok) {
            return "Se eliminó la experiencia con id " + id;
        } else {
            return "No pudo eliminar la experiencia con id " + id;
        }
    }

}
