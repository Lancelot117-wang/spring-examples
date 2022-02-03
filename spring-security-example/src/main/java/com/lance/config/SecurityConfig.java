package com.lance.config;

import com.lance.handler.MyAccessDeniedHandler;
import com.lance.handler.MyAuthenticationFailureHandler;
import com.lance.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private PersistentTokenRepository persistentTokenRepository;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public PersistentTokenRepository persistentTokenRepository(){
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        jdbcTokenRepository.setDataSource(dataSource);
        //jdbcTokenRepository.setCreateTableOnStartup(true);
        return jdbcTokenRepository;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .usernameParameter("usernameField")
                .passwordParameter("passwordField")
                .loginPage("/login.html")
                .loginProcessingUrl("/login")
                .successForwardUrl("/index")
                // implement success redirect to www.baidu.com
                // default SuccessHandler forwards request to target url, not able to point to an external url
                //.successHandler(new MyAuthenticationSuccessHandler("http://www.baidu.com"))
                //.failureForwardUrl("/toError")
                // implement failure redirect to www.google.com
                // default FailureHandler forwards request to target url, not able to point to an external url
                .failureHandler(new MyAuthenticationFailureHandler("http://www.google.com"));

        http.logout()
                // customize logout URL
                //.logoutUrl("/doLogout")
                .logoutSuccessUrl("/login.html");
                //.logoutSuccessHandler()


        http.authorizeRequests()
                .antMatchers("/error.html").permitAll()
                .antMatchers("/login.html").permitAll()
                // permit access to any static resource
                .antMatchers("/css/**", "/js/**", "/images/**").permitAll()
                // permit access to certain type of resources
                //.antMatchers("/**/*.png").permitAll()
                //.regexMatchers(".+[.]png").permitAll()
                //.mvcMatchers("/demo").servletPath("/xxxx").permitAll()
                // authorize according to authority
                // authority is case sensitive
                //.antMatchers("/index1.html").hasAuthority("admin")
                //.antMatchers("/index1.html").hasAnyAuthority("admin", "ADMIN")
                // authorize according to role
                // role is case sensitive
                // role should have prefix "ROLE_" when declared in UserDetails
                //.antMatchers("/index1.html").hasRole("role1")
                //.antMatchers("/index1.html").access("hasPermission()")
                //.antMatchers("/index1.html").hasAnyRole("role1", "role2")
                // authorize according to IP address
                // IP address could vary on local machine
                //.antMatchers("/index1.html").hasIpAddress("127.0.0.1")
                //.anyRequest().access("@myServiceImpl.hasPermission(request, authentication)")
                .anyRequest().authenticated();

        http.exceptionHandling()
                .accessDeniedHandler(new MyAccessDeniedHandler());

        http.rememberMe()
                .tokenRepository(persistentTokenRepository)
                .tokenValiditySeconds(60)
                .userDetailsService(userDetailsService);

        http.csrf().disable();
    }
}
