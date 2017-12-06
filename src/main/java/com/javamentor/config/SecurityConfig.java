package com.javamentor.config;

import com.javamentor.service.security.AuthSuccessHandler;
import com.javamentor.service.security.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;

//@Configuration
//@EnableWebSecurity
//@ComponentScan("com.javamentor")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    AuthenticationService authenticationService;

    @Autowired
    AuthSuccessHandler authSuccessHandler;

    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(authenticationService);

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);
        // отключена защита csrf на время тестов
        http.csrf().disable().addFilterBefore(filter, CsrfFilter.class);

        http.authorizeRequests()
                .antMatchers("/*").hasAnyAuthority("USER", "ADMIN")
                .antMatchers("/adm/**").hasAuthority("ADMIN")
                .and()
                .formLogin()
                .loginPage("/login").usernameParameter("login").passwordParameter("password")
                .failureUrl("/login?error")
                .successHandler(authSuccessHandler);

    }
}
