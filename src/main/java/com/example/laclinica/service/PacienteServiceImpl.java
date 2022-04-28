package com.example.laclinica.service;

import com.example.laclinica.model.Paciente;
import com.example.laclinica.model.PacienteDTO;
import com.example.laclinica.repository.IPacienteRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PacienteServiceImpl implements IPacienteService{

    @Autowired
    IPacienteRepository pacienteRepository;

    @Autowired
    ObjectMapper mapper;

    @Autowired
    ModelMapper modelMapper;



    @Override
    public void createPaciente(PacienteDTO pacienteDTO) {
        savePaciente(pacienteDTO);
    }

    @Override
    public PacienteDTO readPaciente(Long id) {
        Optional<Paciente> found = pacienteRepository.findById(id);
        return mapper.convertValue(found, PacienteDTO.class);
    }

    @Override
    public PacienteDTO updatePaciente(PacienteDTO pacienteDTO) {
        Paciente paciente = modelMapper.map(pacienteDTO, Paciente.class);
        pacienteRepository.save(paciente);
        return modelMapper.map(paciente, PacienteDTO.class);
    }

    @Override
    public List<PacienteDTO> getAll(){
        List<Paciente> paciente = pacienteRepository.findAll();
        return modelMapper.map(paciente, new TypeToken<List<PacienteDTO>>() {}.getType() );

    }

    @Override
    public void deletePaciente(Long id) {
        pacienteRepository.deleteById(id);
    }

    private void savePaciente(PacienteDTO pacienteDTO){
        Paciente newPaciente = modelMapper.map(pacienteDTO, Paciente.class);
        pacienteRepository.save(newPaciente);
    }
}
