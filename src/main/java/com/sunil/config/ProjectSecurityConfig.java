package com.sunil.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {

	@Bean
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeHttpRequests().requestMatchers("/myAccount", "/myBalance", "/myLoans", "/myCards").authenticated()
				// .requestMatchers("/myCards").denyAll()
				.requestMatchers("/notices", "/contact", "/register").permitAll().and().formLogin().and().httpBasic();
		return http.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	/*
	 * @Bean public UserDetailsService userDetailsService(DataSource dataSource) {
	 * return new JdbcUserDetailsManager(dataSource); }
	 * 
	 * @Bean public InMemoryUserDetailsManager userDetailsService() { UserDetails
	 * admin = User.withUsername("sunil") .password("kala") .authorities("admin")
	 * .build(); UserDetails user = User.withUsername("user") .password("12345")
	 * .authorities("read") .build();
	 * 
	 * return new InMemoryUserDetailsManager(admin,user); }
	 */

}
