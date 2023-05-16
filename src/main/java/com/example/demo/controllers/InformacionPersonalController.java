package com.example.demo.controllers;

import com.example.demo.models.InformacionPersonalModel;
import com.example.demo.services.InformacionPersonalService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @DeleteMapping("/{id}")
    public String eliminarInformacionPersonal(@PathVariable("id") Long id){
        boolean ok = informacionPersonalService.eliminarInformacionPersonal(id);
        if (ok){
            return "Se eliminó la información personal con id " + id;
        }else{
            return "No se pudo eliminar la información personal con id " + id;
        }
    }

}
