package com.example.demo.services;

import com.example.demo.models.ProyectosModel;
import com.example.demo.repositories.ProyectosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProyectosService {

    @Autowired
    ProyectosRepository proyectosRepository;

    public ArrayList<ProyectosModel> obtenerProyectos() {
        return (ArrayList<ProyectosModel>) proyectosRepository.findAll();
    }

    public ProyectosModel guardarProyecto(ProyectosModel proyecto) {
        return proyectosRepository.save(proyecto);
    }

    public boolean eliminarProyecto(Integer id) {
        try {
            proyectosRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

}
