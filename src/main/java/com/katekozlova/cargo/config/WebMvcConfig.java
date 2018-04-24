package com.katekozlova.cargo.config;

import com.katekozlova.cargo.business.converter.CityConverter;
import com.katekozlova.cargo.business.converter.DriverConverter;
import com.katekozlova.cargo.business.converter.TruckConverter;
import com.katekozlova.cargo.business.converter.WaypointConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    public CityConverter cityConverter;

    @Autowired
    public DriverConverter driverConverter;

    @Autowired
    TruckConverter truckConverter;

    @Autowired
    WaypointConverter waypointConverter;

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/jsp/", ".jsp");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("/static/");
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(cityConverter);
        registry.addConverter(driverConverter);
        registry.addConverter(truckConverter);
        registry.addConverter(waypointConverter);
    }

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource source = new ResourceBundleMessageSource();
        source.setBasename("messages");
        return source;
    }
}
