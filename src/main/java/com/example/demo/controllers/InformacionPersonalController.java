package com.example.demo.controllers;

import com.example.demo.models.InformacionPersonalModel;
import com.example.demo.services.InformacionPersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/informacionpersonal")
public class InformacionPersonalController {

    @Autowired
    InformacionPersonalService informacionPersonalService;

    @GetMapping()
    public ArrayList<InformacionPersonalModel> obtenerInformacionPersonal() {
        return informacionPersonalService.obtenerInformacionPersonal();
    }

    @PostMapping()
    public InformacionPersonalModel guardarInformacionPersonal(@RequestBody InformacionPersonalModel informacionPersonal) {
        return informacionPersonalService.guardarInformacionPersonal(informacionPersonal);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<RespuestaEliminar> eliminarPorId(@PathVariable("id") Long id) {
        boolean ok = this.informacionPersonalService.eliminarInformacionPersonal(id);
        if (ok) {
            RespuestaEliminar respuesta = new RespuestaEliminar("Se eliminó la informacion con id " + id);
            return ResponseEntity.ok(respuesta);
        } else {
            RespuestaEliminar respuesta = new RespuestaEliminar("No se pudo eliminar la informacion con id " + id);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(respuesta);
        }
    }

}
