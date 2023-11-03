package br.edu.ifsp.spo.juntossomosmais.repos;

import br.edu.ifsp.spo.juntossomosmais.domain.Location;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LocationRepository extends JpaRepository<Location, Long> {
}
