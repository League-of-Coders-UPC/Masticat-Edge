package masticat.shared.infrastructure.documentation.openai.configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {
  @Bean
  public OpenAPI masticatEdgePlatformOpenApi(){
    return new OpenAPI()
        .info(new Info().title("Masticat Edge API")
            .description(
                "Masticat Edge API Documentation")
            .version("v1.0.0")
            .license(new License().name("Apache 2.0").url("https://springdoc.org")))
        .externalDocs(new ExternalDocumentation()
            .description("Masticat Wiki Documentation")
            .url("https://masticat-service.wiki.github.org/docs"));
  }
}