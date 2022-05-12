package org.camel.app.config;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.servlet.CamelHttpTransportServlet;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class RestConfigRouter extends RouteBuilder {

    @Bean
    public ServletRegistrationBean servletRegistrationBean(){
        ServletRegistrationBean registration = new ServletRegistrationBean(new CamelHttpTransportServlet(),
                "/api/v1/*");
        registration.setName("CamelServlet");

        return registration;
    }

    @Override
    public void configure() throws Exception {
        restConfiguration()
            .dataFormatProperty("prettyPrint", "true")
            .component("servlet")
            .bindingMode(RestBindingMode.json);
    }
}
