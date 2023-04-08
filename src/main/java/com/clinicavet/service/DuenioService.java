package com.clinicavet.service;

import com.clinicavet.models.Duenio;
import com.clinicavet.repository.IDuenioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DuenioService implements IDuenioService{

    @Autowired
    private IDuenioRepository duenioRepo;
    
    @Override
    public List<Duenio> traerDuenios() {
       List<Duenio> listaDuenios =duenioRepo.findAll();
       return listaDuenios;
    }

    @Override
    public void guardar(Duenio duenio) {
        duenioRepo.save(duenio);
    }

    @Override
    public void borrar(Long id_duenio) {
        duenioRepo.deleteById(id_duenio);
    }

    @Override
    public Duenio traerDuenio(Long id_duenio) {
        return duenioRepo.findById(id_duenio).orElse(null);
    }

    @Override
    public void editar(Duenio duenio) {
        this.guardar(duenio);
    }
    
}
