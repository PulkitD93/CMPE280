//package com.shikher.ecommerce.config;
//
//import org.apache.commons.dbcp2.BasicDataSource;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Import;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.password.StandardPasswordEncoder;
//
//import javax.activation.DataSource;
//
///**
// * Created by Shikher on 11-Sep-16.
// */
//
//@Configuration
//@Import(DataConfig.class)
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    public static final String loginQuery = "select username, password, enabled from FitbitUser where username = ?";
//    public static final String authorizationQuery = "select username, authority from FitbitUser where username = ?";
//
//
//    @Autowired
//    BasicDataSource dataSource;
//
////    @Override
////    protected void configure(HttpSecurity http) throws Exception {
////
////        http.authorizeRequests()
////                .antMatchers("/admin/**").access("hasRole('ROLE_USER')")
////                .and()
////                .formLogin().loginPage("/login").failureUrl("/login?error")
////                .usernameParameter("username").passwordParameter("password")
////                .and()
////                .logout().logoutSuccessUrl("/login?logout")
////                .and()
////                .csrf();
////    }
//
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin().loginPage("/login").failureUrl("/login?error").permitAll()
//                .and().csrf();
//    }
//
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//
//
//        auth.inMemoryAuthentication()
//                .withUser("user").password("password").roles("USER").and()
//                .withUser("admin").password("password").roles("ADMIN");
//
//        //auth.jdbcAuthentication().dataSource(dataSource).
//          //      usersByUsernameQuery(loginQuery).
//            //    authoritiesByUsernameQuery(authorizationQuery);
//        //.passwordEncoder(new StandardPasswordEncoder("53cr3t"));
//    }
//
//
//}
