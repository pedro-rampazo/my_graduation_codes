package br.edu.ifsp.spo.juntossomosmais.repos;

import br.edu.ifsp.spo.juntossomosmais.domain.MobileNumber;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MobileNumberRepository extends JpaRepository<MobileNumber, Long> {
}
