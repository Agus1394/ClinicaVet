package com.clinicavet.service;

import com.clinicavet.dto.MascotaDuenioDTO;
import com.clinicavet.models.Mascota;
import com.clinicavet.repository.IMascotaRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MascotaService implements IMascotaService{
    
    @Autowired
    private IMascotaRepository mascotaRepo;

    @Override
    public List<Mascota> traerMascotas() {
        List<Mascota> listaMascotas= mascotaRepo.findAll();
        return listaMascotas;
    }

    @Override
    public List<Mascota> traerCaniches() {
        List<Mascota> listaMascota= this.traerMascotas();
        List<Mascota> listaCaniche= new ArrayList<Mascota>();
        
        listaMascota.stream().filter(mascota -> (mascota.getEspecie().equalsIgnoreCase("perro") && mascota.getRaza().equalsIgnoreCase("caniche"))).forEachOrdered(mascota -> {
            listaCaniche.add(mascota);
        });
        return listaCaniche;
    }

    @Override
    public List<MascotaDuenioDTO> traerDuenioMascota() {
        List<Mascota> listaMascotas= this.traerMascotas();
        List<MascotaDuenioDTO> listaMascotaDuenio = new ArrayList<MascotaDuenioDTO>();
        MascotaDuenioDTO mascotaDuenio= new MascotaDuenioDTO();
        
        for (Mascota mascota : listaMascotas) {
            System.out.println(mascota.getNombre());
            mascotaDuenio.setNombreDuenio(mascota.getDuenio().getNombre());
            mascotaDuenio.setApellidoDuenio(mascota.getDuenio().getApellido());
            mascotaDuenio.setNombreMascota(mascota.getNombre());
            mascotaDuenio.setEspecie(mascota.getEspecie());
            mascotaDuenio.setRaza(mascota.getRaza());       
            listaMascotaDuenio.add(mascotaDuenio);
            mascotaDuenio= new MascotaDuenioDTO();
        }
        return listaMascotaDuenio;
    }

    @Override
    public void guardar(Mascota mascota) {
        mascotaRepo.save(mascota);
    }

    @Override
    public void borrar(Long idMascota) {
        mascotaRepo.deleteById(idMascota);
    }

    @Override
    public void editar(Mascota mascota) {
        this.guardar(mascota);
    }

    @Override
    public Mascota buscarMascota(Long idMascota) {
        return mascotaRepo.findById(idMascota).orElse(null);
    }
       
}
