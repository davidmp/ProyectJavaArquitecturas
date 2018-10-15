package pe.edu.upeu.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upeu.entities.Reserva;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Integer> {

}
