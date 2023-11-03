package br.edu.ifsp.spo.juntossomosmais.repos;

import br.edu.ifsp.spo.juntossomosmais.domain.Coordinate;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CoordinateRepository extends JpaRepository<Coordinate, Long> {
}
