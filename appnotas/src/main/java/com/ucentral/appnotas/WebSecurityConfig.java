///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package com.ucentral.appnotas;
//
//
//import javax.sql.DataSource;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//@Configuration
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    private DataSource dataSource;
//
//    @Autowired
//    private BCryptPasswordEncoder passEncoder;
//
//    
//    @Override
//    protected void configure(HttpSecurity http) throws Exception{
//        http.authorizeRequests()
//                .antMatchers("/menu_principal","/","/css/**","/js","/img/**").permitAll()
//                .antMatchers("/views/viewNotas/consultarNotas").hasAnyRole("USER")
//                .antMatchers("/views/viewNotas/registrarNotas").hasAnyRole("ADMIN")
//                .anyRequest().authenticated()
//                .and()
//                .formLogin().loginPage("/login")
//                .permitAll()
//                .and()
//                .logout().permitAll();
//    }
//    
//    
//    
//    @Autowired
//    public void configurerSecurityGlobal(AuthenticationManagerBuilder builder) throws Exception {
//        builder.jdbcAuthentication()
//                .dataSource(dataSource)
//                .passwordEncoder(passEncoder)
//                .usersByUsernameQuery("select nombre, contrasena, enabled from usuarios where nombre = ?")
//                .authoritiesByUsernameQuery("select u.nombre, r.rol from roles r inner join usuarios u on r.user_id = u.identificacion where nombre = ?");
//
//    }
//}
