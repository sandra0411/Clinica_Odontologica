package com.example.laclinica.service;


import com.example.laclinica.model.PacienteDTO;

import java.util.List;

public interface IPacienteService {

    void createPaciente (PacienteDTO pacienteDTO);
    PacienteDTO readPaciente(Long id);
    PacienteDTO updatePaciente (PacienteDTO pacienteDTO);
    List<PacienteDTO> getAll();
    void deletePaciente (Long id);

}
