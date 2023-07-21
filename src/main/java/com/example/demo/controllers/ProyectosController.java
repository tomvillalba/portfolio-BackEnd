package com.example.demo.controllers;

import com.example.demo.models.ProyectosModel;
import com.example.demo.services.ProyectosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/proyectos")
public class ProyectosController {

    @Autowired
    ProyectosService proyectosService;

    @GetMapping()
    public ArrayList<ProyectosModel> obtenerProyectos() {
        return proyectosService.obtenerProyectos();
    }

    @PostMapping()
    public ProyectosModel guardarProyecto(@RequestBody ProyectosModel proyecto) {
        return proyectosService.guardarProyecto(proyecto);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<RespuestaEliminar> eliminarPorId(@PathVariable("id") Integer id) {
        boolean ok = this.proyectosService.eliminarProyecto(id);
        if (ok) {
            RespuestaEliminar respuesta = new RespuestaEliminar("Se eliminó el proyecto con id " + id);
            return ResponseEntity.ok(respuesta);
        } else {
            RespuestaEliminar respuesta = new RespuestaEliminar("No se pudo eliminar el proyecto con id " + id);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(respuesta);
        }
    }

}
