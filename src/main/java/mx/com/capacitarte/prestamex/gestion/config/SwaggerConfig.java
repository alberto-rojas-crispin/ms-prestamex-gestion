package mx.com.capacitarte.prestamex.gestion.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.components(new Components())
				.info(new Info()
						.title("MS Gestion Prestamex API")
						.description("MS con los componentes para la gestión de la aplicación prestamex")
						.version("1.0.0"));
	}
	
}
