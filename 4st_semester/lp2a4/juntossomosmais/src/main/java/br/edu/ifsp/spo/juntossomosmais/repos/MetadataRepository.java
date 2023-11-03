package br.edu.ifsp.spo.juntossomosmais.repos;

import br.edu.ifsp.spo.juntossomosmais.domain.Metadata;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MetadataRepository extends JpaRepository<Metadata, Long> {
}
