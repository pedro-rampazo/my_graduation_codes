package br.edu.ifsp.spo.juntossomosmais.repos;

import br.edu.ifsp.spo.juntossomosmais.domain.Picture;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PictureRepository extends JpaRepository<Picture, Long> {
}
