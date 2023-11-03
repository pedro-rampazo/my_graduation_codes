package br.edu.ifsp.spo.juntossomosmais.repos;

import br.edu.ifsp.spo.juntossomosmais.domain.Timezone;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TimezoneRepository extends JpaRepository<Timezone, Long> {
}
