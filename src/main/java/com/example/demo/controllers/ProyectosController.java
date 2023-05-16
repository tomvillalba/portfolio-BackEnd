package com.example.demo.controllers;

import com.example.demo.models.ProyectosModel;
import com.example.demo.services.ProyectosService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String eliminarPorId(@PathVariable("id") Integer id) {
        boolean ok = proyectosService.eliminarProyecto(id);
        if (ok) {
            return "Se eliminó el proyecto con id " + id;
        } else {
            return "No pudo eliminar el proyecto con id " + id;
        }
    }

}
