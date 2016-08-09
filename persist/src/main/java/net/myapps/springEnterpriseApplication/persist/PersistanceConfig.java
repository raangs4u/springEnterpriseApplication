package net.myapps.springEnterpriseApplication.persist;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author rmandada
 */
@EnableJpaRepositories
@EnableJpaAuditing
@EntityScan("net.myapps.springEnterpriseApplication.model")
@Configuration
@ComponentScan
public class PersistanceConfig {
}
