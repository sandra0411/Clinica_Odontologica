package com.example.laclinica.service;

import com.example.laclinica.model.PacienteDTO;
import com.example.laclinica.model.TurnoDTO;

import java.util.List;

public interface ITurnoService {

    void createTurno(TurnoDTO turnoDTO);
    TurnoDTO readTurno(Long id);
    List<TurnoDTO> getAll();
    TurnoDTO updateTurno (TurnoDTO turnoDTO);
    void deleteTurno (Long id);

}
