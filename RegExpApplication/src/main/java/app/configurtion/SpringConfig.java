package app.configurtion;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc // mvc:annotationDriven
@ComponentScan(basePackages = "app")
public class SpringConfig {
}
