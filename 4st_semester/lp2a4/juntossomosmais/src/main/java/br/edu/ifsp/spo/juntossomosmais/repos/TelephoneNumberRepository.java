package br.edu.ifsp.spo.juntossomosmais.repos;

import br.edu.ifsp.spo.juntossomosmais.domain.TelephoneNumber;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TelephoneNumberRepository extends JpaRepository<TelephoneNumber, Long> {
}
