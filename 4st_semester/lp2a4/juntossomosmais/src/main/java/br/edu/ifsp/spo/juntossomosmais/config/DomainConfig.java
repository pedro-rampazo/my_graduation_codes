package br.edu.ifsp.spo.juntossomosmais.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EntityScan("br.edu.ifsp.spo.juntossomosmais.domain")
@EnableJpaRepositories("br.edu.ifsp.spo.juntossomosmais.repos")
@EnableTransactionManagement
public class DomainConfig {
}
