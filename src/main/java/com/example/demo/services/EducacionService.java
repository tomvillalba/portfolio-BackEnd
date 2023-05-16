package com.example.demo.services;

import com.example.demo.models.EducacionModel;
import com.example.demo.repositories.EducacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class EducacionService {

    @Autowired
    EducacionRepository educacionRepository;

    public ArrayList<EducacionModel> obtenerEducaciones() {
        return (ArrayList<EducacionModel>) educacionRepository.findAll();
    }

    public EducacionModel guardarEducacion(EducacionModel educacion) {
        return educacionRepository.save(educacion);
    }

    public boolean eliminarEducacion(Integer id) {
        try {
            educacionRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

}
