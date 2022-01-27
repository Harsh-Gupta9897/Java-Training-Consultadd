package com.employee.config;


import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@EnableWebSecurity
public class WebSecurityConfig   extends WebSecurityConfigurerAdapter{
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance())
        .withUser("user1").password("asdf").roles("User")
                .and().withUser("user2").password("asdf").roles("Admin");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        // to tell which url need authentication

                http.authorizeRequests()
                .antMatchers("/**").hasRole("User")
                .anyRequest()
                .authenticated()
                .and().formLogin();

                /// for particular path with paritcular role            .antMatchers("/employee").hasRole("")
       /// http.csrf().disable().cors();   // used to allow others ips of system
//        http.sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()

    }
}
