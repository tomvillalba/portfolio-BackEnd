package com.example.demo.services;

import com.example.demo.models.InformacionPersonalModel;
import com.example.demo.repositories.InformacionPersonalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class InformacionPersonalService {

    @Autowired
    InformacionPersonalRepository informacionPersonalRepository;

    public ArrayList<InformacionPersonalModel> obtenerInformacionPersonal(){
        return (ArrayList<InformacionPersonalModel>) informacionPersonalRepository.findAll();
    }

    public InformacionPersonalModel guardarInformacionPersonal(InformacionPersonalModel informacionPersonal){
        return informacionPersonalRepository.save(informacionPersonal);
    }

    public boolean eliminarInformacionPersonal(Long id){
        try{
            informacionPersonalRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }

}
