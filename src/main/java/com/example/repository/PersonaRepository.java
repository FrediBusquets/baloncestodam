package com.example.repository;


import com.example.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.data.domain.Pageable;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by USER on 02/11/2016.
 */
public interface PersonaRepository extends JpaRepository<Persona,Long> {

    List<Persona> findBynombreContaining(String nombre);

    List<Persona>findBycanastastotalesGreaterThanEqual(Integer canastastotales);

    List<Persona>findByasistenciastotalesBetween(Integer minasistenciastotales, Integer maxasistenciastotales);

    List<Persona>findByposicionIs(String posicion);

    List<Persona>findByfechanacimientoBefore(LocalDate fechanacimiento);

    @Query("SELECT persona.posicion, AVG(persona.canastastotales), AVG(persona.asistenciastotales), AVG(persona.rebotestotales) "
            + "FROM Persona persona "
            +"GROUP BY persona.posicion")
    List<Object[]>AVGcanastastotalesANDasistenciastotalesANDrebotestotales();

    @Query("SELECT persona.posicion, AVG(persona.canastastotales), max(persona.canastastotales), min(persona.canastastotales), AVG(persona.asistenciastotales), max(persona.asistenciastotales), min(persona.asistenciastotales), " +
            "AVG(persona.rebotestotales), max(persona.rebotestotales), min(persona.rebotestotales) "
            + "FROM Persona persona "
            +"GROUP BY persona.posicion")
    List<Object[]>AVGANDMaxANDMinTOcanastastotalesANDasistenciastotalesANDrebotestotales();

    List<Persona>findByPerteneceNombreIs(String nombre);

    List<Persona>findByPerteneceNombreIsAndPosicionIs(String nombre, String posicion);

    @Query("SELECT persona " + " FROM Persona persona " + "WHERE persona.pertenece.nombre = :teamnombre"+" ORDER BY persona.canastastotales desc")
    List<Persona>nombrePersona(@Param("teamnombre") String teamnombre, Pageable pageable);
}
