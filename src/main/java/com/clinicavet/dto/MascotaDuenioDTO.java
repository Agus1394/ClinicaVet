package com.clinicavet.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter
@NoArgsConstructor
public class MascotaDuenioDTO {
    
    private String nombreDuenio;
    private String apellidoDuenio;
    private String nombreMascota;
    private String raza;
    private String especie;
    
    
}
