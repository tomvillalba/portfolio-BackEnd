package com.example.demo.controllers;

import com.example.demo.models.EducacionModel;
import com.example.demo.services.EducacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/educacion")
public class EducacionController {

    @Autowired
    EducacionService educacionService;

    @GetMapping()
    public ArrayList<EducacionModel> obtenerEducaciones() {
        return educacionService.obtenerEducaciones();
    }

    @PostMapping()
    public EducacionModel guardarEducacion(@RequestBody EducacionModel educacion) {
        return this.educacionService.guardarEducacion(educacion);
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Integer id) {
        boolean ok = this.educacionService.eliminarEducacion(id);
        if (ok) {
            return "Se eliminó la educación con id " + id;
        } else {
            return "No pudo eliminar la educación con id " + id;
        }
    }

}
