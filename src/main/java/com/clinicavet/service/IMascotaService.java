package com.clinicavet.service;

import com.clinicavet.dto.MascotaDuenioDTO;
import com.clinicavet.models.Mascota;
import java.util.List;


public interface IMascotaService {
    
    public List<Mascota> traerMascotas();
    
    public List<Mascota> traerCaniches();
    
    public List<MascotaDuenioDTO> traerDuenioMascota();
    
    public void guardar(Mascota mascota);
    
    public void borrar(Long idMascota);
    
    public void editar(Mascota mascota);
    
    public Mascota buscarMascota(Long idMascota);
    
    
    
    
}
