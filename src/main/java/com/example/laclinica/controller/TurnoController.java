package com.example.laclinica.controller;

import com.example.laclinica.model.PacienteDTO;
import com.example.laclinica.model.TurnoDTO;
import com.example.laclinica.service.ITurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    @Autowired
    ITurnoService turnoService;

    @PostMapping
    public ResponseEntity<?> addTurno(@RequestBody TurnoDTO turnoDTO)
    {
        turnoService.createTurno(turnoDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public TurnoDTO getTurno(@PathVariable Long id){
        return turnoService.readTurno(id);
    }

    @GetMapping("/list")
    public List<TurnoDTO> listTurnos()
    {
        return turnoService.getAll();
    }

    @PostMapping("/modify")
    public TurnoDTO actualizarTurno(@RequestBody TurnoDTO turnoDTO){
        return turnoService.updateTurno(turnoDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TurnoDTO> borrarTurno(@PathVariable Long id){
        turnoService.deleteTurno(id);
        return ResponseEntity.ok(null);
    }


}
