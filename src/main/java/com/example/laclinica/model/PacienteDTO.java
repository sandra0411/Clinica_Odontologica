package com.example.laclinica.model;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
public class PacienteDTO {

    private Long id;
    private String nombre;
    private String apellido;
    private Domicilio domicilio;
    private String dni;
    private Date fechaIngreso;



}
