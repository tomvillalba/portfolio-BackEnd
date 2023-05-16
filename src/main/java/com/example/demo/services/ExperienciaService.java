package com.example.demo.services;

import com.example.demo.models.ExperienciaModel;
import com.example.demo.repositories.ExperienciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class ExperienciaService {

    @Autowired
    ExperienciaRepository experienciaRepository;

    public ArrayList<ExperienciaModel> obtenerExperiencias() {
        return (ArrayList<ExperienciaModel>) experienciaRepository.findAll();
    }

    public ExperienciaModel guardarExperiencia(ExperienciaModel experiencia) {
        return experienciaRepository.save(experiencia);
    }

    public boolean eliminarExperiencia(Integer id) {
        try {
            experienciaRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

}

