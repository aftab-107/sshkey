package com.OneToMany.SecurityConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class MySecurityConfig
{

	//authentication
	@Bean
	public UserDetailsService userDetailsService() {
	    UserDetails admin = User.withUsername("admin")
	            .password(passwordEncoder().encode("admin123"))
	            .roles("ADMIN")
	            .build();
	    UserDetails user = User.withUsername("student")
	            .password(passwordEncoder().encode("student123"))
	            .roles("USER")
	            .build();
	    return new InMemoryUserDetailsManager(admin, user);
	   
	}
	
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	//authorization
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
	{
		//http.csrf().disable()
//		 http.csrf(csrf -> csrf.disable())
//		.authorizeHttpRequests((authorize)->authorize.anyRequest().authenticated())
//		.httpBasic(Customizer.withDefaults());
//		return http.build();
		 http.csrf(csrf -> csrf.disable())
		.authorizeHttpRequests((requests)->requests
		.requestMatchers(new AntPathRequestMatcher("/user")).permitAll()
		.requestMatchers(new AntPathRequestMatcher("/newuser")).permitAll()
      .anyRequest().authenticated())
		.httpBasic(Customizer.withDefaults());
	   return http.build();
	}
//	@Bean
//	public AuthenticationProvider authenticationProvider()
//	{
//		DaoAuthenticationProvider authenticationProvider=new DaoAuthenticationProvider();
//		authenticationProvider.setUserDetailsService(userDetailsService());
//		authenticationProvider.setPasswordEncoder(passwordEncoder());
//		return authenticationProvider();
//	}
}
