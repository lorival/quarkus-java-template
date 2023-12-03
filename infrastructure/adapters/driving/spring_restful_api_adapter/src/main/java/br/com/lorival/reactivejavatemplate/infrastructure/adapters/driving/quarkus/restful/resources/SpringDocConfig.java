package br.com.lorival.reactivejavatemplate.infrastructure.adapters.driving.quarkus.restful.resources;

import java.util.Optional;
import org.springdoc.core.configuration.SpringDocConfiguration;
import org.springdoc.core.configuration.SpringDocUIConfiguration;
import org.springdoc.core.properties.SpringDocConfigProperties;
import org.springdoc.core.properties.SwaggerUiConfigProperties;
import org.springdoc.core.providers.ObjectMapperProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfig {

  @Bean
  SpringDocConfiguration springDocConfiguration() {
    return new SpringDocConfiguration();
  }

  @Bean
  SpringDocConfigProperties springDocConfigProperties() {
    return new SpringDocConfigProperties();
  }

  @Bean
  ObjectMapperProvider objectMapperProvider(SpringDocConfigProperties springDocConfigProperties) {
    return new ObjectMapperProvider(springDocConfigProperties);
  }

  @Bean
  SpringDocUIConfiguration SpringDocUIConfiguration(
      SwaggerUiConfigProperties swaggerUiConfigProperties) {
    Optional<SwaggerUiConfigProperties> optionalSwaggerUiConfigProperties =
        Optional.of(swaggerUiConfigProperties);
    return new SpringDocUIConfiguration(optionalSwaggerUiConfigProperties);
  }
}
