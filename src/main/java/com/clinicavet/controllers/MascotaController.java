package com.clinicavet.controllers;

import com.clinicavet.dto.MascotaDuenioDTO;
import com.clinicavet.models.Mascota;
import com.clinicavet.service.IMascotaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mascota")
public class MascotaController {
    
    @Autowired
    private IMascotaService mascotaService;
    
    @GetMapping("/traer-todas")
    public List<Mascota> traerMascotas(){    
        return mascotaService.traerMascotas();
    }
    
    @PostMapping("/crear")
    public String guardar(@RequestBody Mascota mascota){
        mascotaService.guardar(mascota);
        return "Mascota guardada correctamente";
    }
    
    @PutMapping("/editar")
    public String editar(@RequestBody Mascota mascota){
        mascotaService.editar(mascota);
        return "Mascota editada";
    }
    
    @DeleteMapping("/borrar/{id_mascota}")
    public String borrar(@PathVariable Long id_mascota){
        mascotaService.borrar(id_mascota);
        return "Mascota eliminada!";     
    }
    
    @GetMapping("/traer-caniche")
    public List<Mascota> traerCaniches(){       
        return mascotaService.traerCaniches();       
    }
    
    @GetMapping("/traer-duenio")
    public List<MascotaDuenioDTO> traerDuenioMascota(){       
        return mascotaService.traerDuenioMascota();
    }    
}
