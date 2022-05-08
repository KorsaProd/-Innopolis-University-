package ru.pcs.attestation.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserDetailsService userDetailsServiceImpl;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/home").authenticated()
                .antMatchers("/signUp").permitAll()
                .antMatchers("/adminPage").hasAuthority("ADMIN")
                .antMatchers("/adminPage/**").hasAuthority("ADMIN")
                .antMatchers("/customerPage").hasAuthority("CUSTOMER")
                .antMatchers("/customerPage/**").hasAuthority("CUSTOMER")
                .antMatchers("/companyPage/**").hasAuthority("COMPANY")
                .antMatchers("/userPage").authenticated()
                .and()
                .formLogin()
                .loginPage("/signIn")
                .defaultSuccessUrl("/home")
                .usernameParameter("email")
                .passwordParameter("password")
                .permitAll();
    }
}
