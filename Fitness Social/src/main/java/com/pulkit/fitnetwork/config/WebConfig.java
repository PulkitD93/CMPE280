package com.pulkit.fitnetwork.config;

import com.pulkit.fitnetwork.trigger.PreviousTriggers;
import com.pulkit.fitnetwork.trigger.Trigger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Shikher on 09-Sep-16.
 */

@Configuration
@EnableWebMvc
@ComponentScan({"com.shikher.fitnetwork"})
public class WebConfig extends WebMvcConfigurerAdapter {

    /**
     * JSP View resolver
     *
     * @return
     */

//    @Bean
//    public ViewResolver viewResolver() {
//        InternalResourceViewResolver resolver =
//                new InternalResourceViewResolver();
//        resolver.setPrefix("/WEB-INF/views/");
//        resolver.setSuffix(".jsp");
//        resolver.setViewClass(
//                org.springframework.web.servlet.view.JstlView.class);
//        return resolver;
//    }

    /**
     * Configure static content handling(html,css,images)
     *
     * @param configurer
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/web/app/**").addResourceLocations("/web/app/");
//    }


    @Bean
    public JWTConfiguration jwtConfiguration() {
        return new JWTConfiguration();
    }

    @Bean
    public PreviousTriggers previousTriggers() {
        return new PreviousTriggers();
    }

    @Bean
    public Trigger triggerSystem() {
        return new Trigger();
    }

}
