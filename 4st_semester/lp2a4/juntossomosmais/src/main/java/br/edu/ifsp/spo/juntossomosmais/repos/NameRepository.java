package br.edu.ifsp.spo.juntossomosmais.repos;

import br.edu.ifsp.spo.juntossomosmais.domain.Name;
import org.springframework.data.jpa.repository.JpaRepository;


public interface NameRepository extends JpaRepository<Name, Long> {
}
