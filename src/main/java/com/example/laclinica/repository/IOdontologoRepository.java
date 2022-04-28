package com.example.laclinica.repository;

import com.example.laclinica.model.Odontologo;
import com.example.laclinica.model.OdontologoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IOdontologoRepository extends JpaRepository<Odontologo, Long> {

//    @Query("select a from Odontologo a where a.id=?1")
//    Optional<OdontologoDTO> buscarOdontologo(Long id);
}


