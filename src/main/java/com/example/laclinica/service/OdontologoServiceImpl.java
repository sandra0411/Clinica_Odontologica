package com.example.laclinica.service;
import com.example.laclinica.model.Odontologo;
import com.example.laclinica.model.OdontologoDTO;
import com.example.laclinica.repository.IOdontologoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class OdontologoServiceImpl implements IOdontologoService{

    @Autowired
    IOdontologoRepository odontologoRepository;

    @Autowired
    ObjectMapper mapper;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public void createOdontologo(OdontologoDTO odontologoDTO) {
        saveOdontologo(odontologoDTO);
    }


//    @Override
//    public OdontologoDTO readOdontologo(Long id) {
//        Odontologo found = odontologoRepository.getById(id);
//        return modelMapper.map(found, OdontologoDTO.class);
//    }

    @Override
    public OdontologoDTO readOdontologo(Long id) {
        Optional<Odontologo> found = odontologoRepository.findById(id);
        return mapper.convertValue(found, OdontologoDTO.class);
    }

    @Override
    public OdontologoDTO updateOdontologo(OdontologoDTO odontologoDTO) {
        Odontologo odontologo = modelMapper.map(odontologoDTO, Odontologo.class);
        odontologoRepository.save(odontologo);
        return modelMapper.map(odontologo, OdontologoDTO.class);

    }

    @Override
    public void deleteOdontologo(Long id) {
        odontologoRepository.deleteById(id);
    }

    @Override
    public List<OdontologoDTO> getAll(){
        List<Odontologo> odontologos = odontologoRepository.findAll();
        return modelMapper.map(odontologos, new TypeToken<List<OdontologoDTO>>() {}.getType() );

    }

    private void saveOdontologo(OdontologoDTO odontologoDTO){
        Odontologo newOdontologo = modelMapper.map(odontologoDTO, Odontologo.class);
        odontologoRepository.save(newOdontologo);
    }


}
