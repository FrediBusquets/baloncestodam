package com.example.repository;

import com.example.domain.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by USER on 02/11/2016.
 */
public interface EquipoRepository extends JpaRepository<Equipo,Long> {

    List<Equipo> findByLocalidadIs(String localidad);
}
