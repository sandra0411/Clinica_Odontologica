package com.example.laclinica.controller;

import com.example.laclinica.model.OdontologoDTO;
import com.example.laclinica.model.PacienteDTO;
import com.example.laclinica.service.OdontologoServiceImpl;
import com.example.laclinica.service.PacienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    PacienteServiceImpl pacienteService;

    @PostMapping("/add")
    public ResponseEntity<?> addPaciente(@RequestBody PacienteDTO paciente) {
        pacienteService.createPaciente(paciente);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public PacienteDTO getPaciente(@PathVariable Long id){
        return pacienteService.readPaciente(id);
    }

    @GetMapping()
    public List<PacienteDTO> listarPacientes(){
        return  pacienteService.getAll();
    }

    @PostMapping("/modify")
    public PacienteDTO actualizarPaciente(@RequestBody PacienteDTO pacienteDTO){
        return pacienteService.updatePaciente(pacienteDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PacienteDTO> borrarPaciente(@PathVariable Long id){
        pacienteService.deletePaciente(id);
        return ResponseEntity.ok(null);
    }
}
