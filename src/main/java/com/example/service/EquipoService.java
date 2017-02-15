package com.example.service;

import com.example.domain.Equipo;
import com.example.repository.EquipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

/**
 * Created by USER on 02/11/2016.
 */
@Service
public class EquipoService {
    @Autowired
    private EquipoRepository equipoRepository;

    public void testEquipo(){

        Equipo equipo1 = new Equipo();
        equipo1.setNombre("Sevilla FC");
        equipo1.setLocalidad("Sevilla");
        equipo1.setFechacreacion(LocalDate.of(2001, 11, 3));
        equipoRepository.save(equipo1);

        Equipo equipo2 = new Equipo();
        equipo2.setNombre("RCD Español");
        equipo2.setLocalidad("Cornella de Llobregat");
        equipo2.setFechacreacion(LocalDate.of(2003, 8, 15));
        equipoRepository.save(equipo2);

        Equipo equipo3 = new Equipo();
        equipo3.setNombre("Real Madrid");
        equipo3.setLocalidad("Madrid");
        equipo3.setFechacreacion(LocalDate.of(1989, 6, 21));
        equipoRepository.save(equipo3);

        Equipo equipo4 = new Equipo();
        equipo3.setNombre("FC Betis");
        equipo3.setLocalidad("Sevilla");
        equipo3.setFechacreacion(LocalDate.of(1987 , 5, 30));
        equipoRepository.save(equipo4);

        Equipo equipo5 = new Equipo();
        equipo3.setNombre("FC Zaragoza");
        equipo3.setLocalidad("Zaragoza");
        equipo3.setFechacreacion(LocalDate.of(1993, 7, 17));
        equipoRepository.save(equipo5);

}
}
