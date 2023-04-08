package com.clinicavet.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Entity
public class Mascota {
    
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Long id;

    private String nombre;
    private String especie;
    private String raza;
    private String color;
    
    /*
    Mascota tiene un dueño como único responsable,
    Por eso hice la relación 1 a 1
    */
    @OneToOne
    private Duenio duenio;
}
