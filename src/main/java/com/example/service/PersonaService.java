package com.example.service;

import com.example.domain.Equipo;
import com.example.domain.Persona;
import com.example.repository.EquipoRepository;
import com.example.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class PersonaService {
    @Autowired
    private EquipoRepository equipoRepository;
    @Autowired
    private PersonaRepository personaRepository;
    public void testPersona(){

        Persona persona1 = new Persona("Jorge Busquets", LocalDate.of(1993, 3, 3), 6, 7, 1, "alero");
        Persona persona2 = new Persona("Alejandro Castro", LocalDate.of(1994, 4, 4), 9, 6, 3, "base");
        Persona persona3 = new Persona("Jordi Garcia", LocalDate.of(1995, 5, 5), 4, 8, 2, "pivot");
        persona1.setPertenece(equipoRepository.findOne(1L));
        personaRepository.save(persona1);
        persona2.setPertenece(equipoRepository.findOne(1L));
        personaRepository.save(persona2);
        persona3.setPertenece(equipoRepository.findOne(1L));
        personaRepository.save(persona3);

        Persona persona4 = new Persona("Javier Segura", LocalDate.of(1986, 6, 6), 8, 9, 3, "alero");
        Persona persona5 = new Persona("Pau Gasol", LocalDate.of(1987, 7, 7), 9, 5, 2, "base");
        Persona persona6 = new Persona("Ivan Puchades", LocalDate.of(1988, 8, 8), 7, 10, 4, "pivot");
        Equipo español = equipoRepository.findOne(2L);
        persona4.setPertenece(español);
        personaRepository.save(persona4);
        persona5.setPertenece(español);
        personaRepository.save(persona5);
        persona6.setPertenece(español);
        personaRepository.save(persona6);

        Persona persona7 = new Persona("Jhon Gimenez", LocalDate.of(1989, 9, 9), 11, 13, 15, "alero");
        Persona persona8 = new Persona("Pepe montojo", LocalDate.of(1991, 1, 15), 2, 3, 11, "base");
        Persona persona9 = new Persona("Alfredo Martinez", LocalDate.of(1992, 2, 1), 3, 7, 5, "alero");
        Equipo madrid = equipoRepository.findOne(3L);
        persona7.setPertenece(madrid);
        personaRepository.save(persona7);
        persona8.setPertenece(madrid);
        personaRepository.save(persona8);
        persona9.setPertenece(madrid);
        personaRepository.save(persona9);

        Persona persona10 = new Persona("Sergio Arias", LocalDate.of(1998, 9, 7), 11, 3, 5, "pivot");
        Persona persona11 = new Persona("Larry potter", LocalDate.of(1997, 5, 8), 12, 13, 11, "base");
        Persona persona12 = new Persona("Juan Muñoz", LocalDate.of(1996, 2, 15), 4, 7, 15, "alero");
        Equipo sevilla = equipoRepository.findOne(4L);
        persona10.setPertenece(sevilla);
        personaRepository.save(persona10);
        persona11.setPertenece(sevilla);
        personaRepository.save(persona11);
        persona12.setPertenece(sevilla);
        personaRepository.save(persona12);

        Persona persona13 = new Persona("Xavier Albalat", LocalDate.of(1989, 8, 7), 12, 1, 11, "pivot");
        Persona persona14 = new Persona("Hector Gomez", LocalDate.of(1994, 5, 15), 13, 2, 11, "base");
        Persona persona15 = new Persona("Victor Martinez", LocalDate.of(1995, 7, 17), 9, 9, 7, "pivot");
        Equipo zaragoza = equipoRepository.findOne(5L);
        persona13.setPertenece(zaragoza);
        personaRepository.save(persona13);
        persona14.setPertenece(zaragoza);
        personaRepository.save(persona14);
        persona15.setPertenece(zaragoza);
        personaRepository.save(persona15);


        System.out.println("El equipo de Cornella de Llobregat es: " +equipoRepository.findByLocalidadIs("Cornella de Llobregat"));
        System.out.println("Los jugadores que su nombre empieza por Jo: " +personaRepository.findBynombreContaining("Jo"));
        System.out.println("Juadores que han hecho 8 canastas o mas: "+personaRepository.findBycanastastotalesGreaterThanEqual(8));
        System.out.println("Jugadores que tienen entre 6 y 11 asistencias: "+personaRepository.findByasistenciastotalesBetween(6, 12));
        System.out.println("Jugadores que su posicion sea alero: "+personaRepository.findByposicionIs("alero"));
        System.out.println("Jugadores que su fecha de nacimiento sea antes del 2000-01-31"+personaRepository.findByfechanacimientoBefore(LocalDate.of(2000, 01, 31)));

        System.out.println("Media de las canastas, asistencias y rebotes de los jugadores agrupados por su posicion");
        AVGCanastasYAssistenciasYRebotes(personaRepository.AVGcanastastotalesANDasistenciastotalesANDrebotestotales());
        System.out.println("Media, Maximo y Minimo de las canastas, asitencias y rebotes: ");
        AVGAMaxMinCanstasAsistenciasRebotes(personaRepository.AVGANDMaxANDMinTOcanastastotalesANDasistenciastotalesANDrebotestotales());
        System.out.println("Los jugadores del Real Madrid son: "+personaRepository.findByPerteneceNombreIs("Real Madrid"));
        System.out.println("Los jugadores de un equipo que jueguen en la misma posición "+personaRepository.findByPerteneceNombreIsAndPosicionIs("Real Madrid", "alero"));
        System.out.println("jugador que más canastas ha realizado de un equipo determinado como parámetro."+personaRepository.nombrePersona("Betis", new PageRequest(0, 1)));
    }

    private void AVGCanastasYAssistenciasYRebotes(List<Object[]> statisticsList) {
        for ( Object[] statistic: statisticsList)
        {
            System.out.println("Posicion en el campo: "+statistic[0]);
            System.out.println("Canastas AVG = "+statistic[1]);
            System.out.println("Asistencias AVG = "+statistic[2]);
            System.out.println("Rebotes AVG = "+statistic[3]+System.lineSeparator());
        }
    }

    private void AVGAMaxMinCanstasAsistenciasRebotes(List<Object[]> statisticsList) {
        for ( Object[] statistic: statisticsList)
        {
            System.out.println("Posicion en el campo: "+statistic[0]);
            System.out.println("Canastas AVG = "+statistic[1]);
            System.out.println("Asistencias AVG = "+statistic[2]);
            System.out.println("Rebotes AVG = "+statistic[3]);
            System.out.println("Canastas Max = "+statistic[4]);
            System.out.println("Asistencias Max = "+statistic[5]);
            System.out.println("Rebotes Max = "+statistic[6]);
            System.out.println("Canastas Min = "+statistic[7]);
            System.out.println("Asistencias Min = "+statistic[8]);
            System.out.println("Rebotes Min = "+statistic[9]+System.lineSeparator());
        }
    }

}
