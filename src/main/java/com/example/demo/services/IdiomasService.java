package com.example.demo.services;

import com.example.demo.models.IdiomasModel;
import com.example.demo.repositories.IdiomasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class IdiomasService {

    @Autowired
    IdiomasRepository idiomasRepository;

    public ArrayList<IdiomasModel> obtenerIdiomas() {
        return (ArrayList<IdiomasModel>) idiomasRepository.findAll();
    }

    public IdiomasModel guardarIdioma(IdiomasModel idioma) {
        return idiomasRepository.save(idioma);
    }

    public boolean eliminarIdioma(Integer id) {
        try {
            idiomasRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

}
