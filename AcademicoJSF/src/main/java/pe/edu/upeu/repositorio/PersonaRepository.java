/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
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
    
}
