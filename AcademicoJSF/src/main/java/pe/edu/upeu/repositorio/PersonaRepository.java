/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.repositorio;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upeu.modelo.Persona;

/**
 *
 * @author davidmp
 */
@Repository
@Transactional
public interface PersonaRepository extends JpaRepository<Persona, Integer>{

    @Query("select p from Persona p where p.nombre like :nombre")
    List<Persona> findByNameColumEntidad(@Param("nombre") String nombre);  
    
    @Query("select p from Persona p where p.nombre like ?1")
    List<Persona> findByNameColumEntidad2(String nombre);
}
