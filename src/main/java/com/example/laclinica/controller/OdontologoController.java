package com.example.laclinica.controller;

import com.example.laclinica.model.OdontologoDTO;
import com.example.laclinica.service.OdontologoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {

    @Autowired
    OdontologoServiceImpl odontologoService;

    @PostMapping("/add")
    public ResponseEntity<?>addOdontologo(@RequestBody OdontologoDTO odont) {
        odontologoService.createOdontologo(odont);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public OdontologoDTO getOdontologo(@PathVariable  Long id){
        return odontologoService.readOdontologo(id);
    }

    @GetMapping()
    public List<OdontologoDTO> listarOdontologos(){
        return  odontologoService.getAll();
    }

    @PostMapping("/modify")
    public OdontologoDTO actualizarOdont(@RequestBody OdontologoDTO odontologoDTO){
        return odontologoService.updateOdontologo(odontologoDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<OdontologoDTO> borrarOdont(@PathVariable Long id){
        odontologoService.deleteOdontologo(id);
        return ResponseEntity.ok(null);
    }

}
