package com.example.demo.controllers;

import com.example.demo.models.IdiomasModel;
import com.example.demo.services.IdiomasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/idiomas")
public class IdiomasController {

    @Autowired
    IdiomasService idiomasService;

    @GetMapping()
    public ArrayList<IdiomasModel> obtenerIdiomas() {
        return idiomasService.obtenerIdiomas();
    }

    @PostMapping()
    public IdiomasModel guardarIdioma(@RequestBody IdiomasModel idioma) {
        return this.idiomasService.guardarIdioma(idioma);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<RespuestaEliminar> eliminarPorId(@PathVariable("id") Integer id) {
        boolean ok = this.idiomasService.eliminarIdioma(id);
        if (ok) {
            RespuestaEliminar respuesta = new RespuestaEliminar("Se eliminó el idioma con id " + id);
            return ResponseEntity.ok(respuesta);
        } else {
            RespuestaEliminar respuesta = new RespuestaEliminar("No se pudo eliminar el idioma con id " + id);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(respuesta);
        }
    }

}
