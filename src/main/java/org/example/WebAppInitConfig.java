package org.example;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

@Configuration
class WebAppInitConfig implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext context) {
        AnnotationConfigWebApplicationContext webAppContext = new AnnotationConfigWebApplicationContext();

        webAppContext.setConfigLocation("org.example");
        context.addListener(new ContextLoaderListener(webAppContext));

        ServletRegistration.Dynamic dispatcher = context
                .addServlet("dispatcher", new DispatcherServlet(webAppContext));

        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");

    }
}