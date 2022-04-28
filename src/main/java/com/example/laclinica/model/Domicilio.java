package com.example.laclinica.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@Getter
@Setter
public class Domicilio {

    @Id
    @GeneratedValue
    private Long id;

    private String calle;
    private String numero;
    private String localidad;
    private String provincia;

}
