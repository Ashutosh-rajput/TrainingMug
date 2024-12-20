package TrainingMug.Car.Management.AppConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.softnerve.Patient_MicroService.controller"))
                .build()
                .apiInfo(apiInfo()); // Attach metadata here
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Car Management Application")
                .description("This project is designed to manage Car information and offers functions for creating, updating, deleting, and retrieving Cars records.")
                .version("1.0")
                .contact(new Contact("Ashutosh Rajput", null, "rajputashuotsh81@gmail.com"))
                .build();
    }
}
