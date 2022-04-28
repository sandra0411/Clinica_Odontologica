package com.example.laclinica.service;

import com.example.laclinica.model.OdontologoDTO;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface IOdontologoService {

    void createOdontologo (OdontologoDTO odontologoDTO);
    OdontologoDTO readOdontologo(Long id);
    OdontologoDTO updateOdontologo (OdontologoDTO odontologoDTO);
    List<OdontologoDTO> getAll();
    void deleteOdontologo (Long id);


}
