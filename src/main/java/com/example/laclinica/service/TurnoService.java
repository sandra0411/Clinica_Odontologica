package com.example.laclinica.service;

import com.example.laclinica.model.Paciente;
import com.example.laclinica.model.PacienteDTO;
import com.example.laclinica.model.Turno;
import com.example.laclinica.model.TurnoDTO;
import com.example.laclinica.repository.ITurnoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TurnoService implements ITurnoService {

    @Autowired
    ITurnoRepository turnoRepository;

    @Autowired
    ObjectMapper mapper;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public void createTurno(TurnoDTO turnoDTO) {
        Turno turno = mapper.convertValue(turnoDTO, Turno.class);
        turnoRepository.save(turno);
    }

    @Override
    public TurnoDTO readTurno(Long id) {
        Optional<Turno> found = turnoRepository.findById(id);
        return mapper.convertValue(found, TurnoDTO.class);
    }


    @Override
    public List<TurnoDTO> getAll() {
        List<Turno> turno = turnoRepository.findAll();
        return modelMapper.map(turno, new TypeToken<List<TurnoDTO>>() {
        }.getType());

    }

    @Override
    public TurnoDTO updateTurno(TurnoDTO turnoDTO) {
        Turno turno = modelMapper.map(turnoDTO, Turno.class);
        turnoRepository.save(turno);
        return modelMapper.map(turno, TurnoDTO.class);
    }

    @Override
    public void deleteTurno(Long id) {
        turnoRepository.deleteById(id);
    }




}

