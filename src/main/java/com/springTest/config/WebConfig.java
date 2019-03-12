package com.springTest.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
//@ComponentScans(value = {
//        @ComponentScan("com.springTest.controller")
//
//})
        //(basePackages = {"com.springTest.controller"})
@ComponentScan( "com.springTest.controller")
//        excludeFilters = { @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Configuration.class) })

//@ComponentScan(basePackageClasses = AppConfig.class,
//        useDefaultFilters=false, includeFilters={@ComponentScan.Filter(org.springframework.stereotype.Controller.class)})
public class WebConfig implements WebMvcConfigurer { //WebMvcConfigurerAdapter


}
