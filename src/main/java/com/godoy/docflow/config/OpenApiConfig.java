package com.godoy.docflow.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

	@Bean
	OpenAPI docflowOpenApi() {
		return new OpenAPI()
				.info(new Info()
						.title("DocFlow API")
						.description("Upload e processamento assíncrono de documentos com AWS (S3, SQS, SNS e SES)")
						.version("v1"));
	}

}
