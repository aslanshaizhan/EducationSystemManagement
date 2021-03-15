package iitu.kz.demo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackages = "iitu.kz.demo")
@PropertySource("application.properties")
@EnableJpaRepositories(basePackages = "iitu.kz.demo")
public class SpringConfiguration {
}
