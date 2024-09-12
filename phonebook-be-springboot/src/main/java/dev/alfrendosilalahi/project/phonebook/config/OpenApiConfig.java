package dev.alfrendosilalahi.project.phonebook.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Phone Book API",
                description = "Phone Book API with CRUD operations.",
                version = "v1.0.0",
                contact = @Contact(
                        name = "Alfrendo Silalahi",
                        email = "alfrendos72@gmail.com",
                        url = "https://github.com/alfrendo-silalahi"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "https://www.apache.org/licenses/LICENSE-2.0"
                )
        )
)
public class OpenApiConfig {
}
