package com.clinicavet.service;

import com.clinicavet.models.Duenio;
import java.util.List;


public interface IDuenioService {
    
    public List<Duenio> traerDuenios();
    
    public void guardar(Duenio duenio);
    
    public void borrar(Long id_duenio);
    
    //Método que traerá sólo a un Dueño
    public Duenio traerDuenio(Long id_duenio);
    
    public void editar(Duenio duenio);
    
}
