package com.clinicavet.controllers;

import com.clinicavet.models.Duenio;
import com.clinicavet.service.IDuenioService;
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
@RequestMapping("/duenio")
public class DuenioController {
    
    @Autowired
    private IDuenioService duenioService;
    
    @GetMapping("/traer-duenios")
    public List<Duenio> traerDuenio(){        
        return duenioService.traerDuenios();      
    }
    
    @PostMapping("/guardar")
    public String guardar(@RequestBody Duenio duenio){
        duenioService.guardar(duenio);
        return "Dueño guardado correctamente";
    }
    
    @DeleteMapping("/borrar/{id_duenio}")
    public String borrar(@PathVariable Long id_duenio){
        duenioService.borrar(id_duenio);
        return "Dueño eliminado";    
    }
    
    @PutMapping("/editar")
    public Duenio editar(@RequestBody Duenio duenio){
        duenioService.editar(duenio);
        return duenioService.traerDuenio(duenio.getId());     
    }
}
