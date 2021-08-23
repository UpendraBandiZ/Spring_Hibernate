package com.springdemo.project.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

import javax.sql.DataSource;


@Configuration
@EnableWebSecurity
@ComponentScan(basePackages = "com.springdemo.project")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource securityDataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth)throws Exception
    {
//        User.UserBuilder users = User.withDefaultPasswordEncoder();
//
//        auth.inMemoryAuthentication()
//                .withUser(users.username("mary").password("test123").roles("COMPANY"))
//                .withUser(users.username("admin").password("test123").roles("ADMIN"));
        auth.jdbcAuthentication().dataSource(securityDataSource);
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                //.anyRequest().authenticated()
                .antMatchers("/company/**").hasRole("ADMIN")
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/city/**").hasRole("COMPANY")
                .antMatchers("/").hasAnyRole("COMPANY","ADMIN")
                .antMatchers("/signUp").permitAll()
                .antMatchers("/register").permitAll()
                .and()
                .formLogin()
                .loginPage("/showMyLoginPage")
                .loginProcessingUrl("/authenticateTheUser")
                .permitAll()
                .and()
                .logout().permitAll()
                .and()
                .exceptionHandling()
                .accessDeniedPage("/access-denied");

        //.antMatchers("/company//**").hasRole("ADMIN")
        // )

//.antMatchers("/test").permitAll()
//                .antMatchers("/api/**").permitAll()
//                .anyRequest().authenticated();


    }

}
