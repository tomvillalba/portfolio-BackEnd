package com.example.demo.controllers;

import com.example.demo.models.ExperienciaModel;
import com.example.demo.services.ExperienciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<RespuestaEliminar> eliminarPorId(@PathVariable("id") Integer id) {
        boolean ok = this.experienciaService.eliminarExperiencia(id);
        if (ok) {
            RespuestaEliminar respuesta = new RespuestaEliminar("Se eliminó la experiencia con id " + id);
            return ResponseEntity.ok(respuesta);
        } else {
            RespuestaEliminar respuesta = new RespuestaEliminar("No se pudo eliminar la experiencia con id " + id);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(respuesta);
        }
    }

}

