package com.pulkit.fitnetwork.config;

import org.springframework.context.annotation.*;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@Configuration
@Import(DataConfig.class)
@ComponentScan(basePackages = {"com.shikher.fitnetwork"},
        excludeFilters = {
                @Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)
        }
)

public class RootConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
