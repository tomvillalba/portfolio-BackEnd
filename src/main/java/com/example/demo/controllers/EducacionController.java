package com.example.demo.controllers;

import com.example.demo.models.EducacionModel;
import com.example.demo.services.EducacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<RespuestaEliminar> eliminarPorId(@PathVariable("id") Integer id) {
        boolean ok = this.educacionService.eliminarEducacion(id);
        if (ok) {
            RespuestaEliminar respuesta = new RespuestaEliminar("Se eliminó la educación con id " + id);
            return ResponseEntity.ok(respuesta);
        } else {
            RespuestaEliminar respuesta = new RespuestaEliminar("No se pudo eliminar la educación con id " + id);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(respuesta);
        }
    }

}
class RespuestaEliminar {
    private String mensaje;

    public RespuestaEliminar(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}