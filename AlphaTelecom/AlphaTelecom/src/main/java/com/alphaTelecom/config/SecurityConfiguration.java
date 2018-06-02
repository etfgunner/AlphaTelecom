package com.alphaTelecom.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
	}

	@Autowired
	private SimpleAuthenticationSuccessHandler successHandler;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().requireCsrfProtectionMatcher(new AntPathRequestMatcher("**/login")).and().authorizeRequests()
				.antMatchers("/korisnik/home").hasAuthority("KORISNIK")
				.antMatchers("/administrator/home").hasAuthority("ADMIN")
				.antMatchers("/administrator/problemi").hasAuthority("ADMIN")
				.antMatchers("/administrator/usluge").hasAuthority("ADMIN")
				.antMatchers("/administrator/zahtjevi").hasAuthority("ADMIN")
				.antMatchers("/korisnik/problemi").hasAuthority("KORISNIK")
				.antMatchers("/korisnik/usluge").hasAuthority("KORISNIK")
				.antMatchers("/korisnik/zahtjevi").hasAuthority("KORISNIK")
				.antMatchers("/problem/new").hasAuthority("KORISNIK")
				.antMatchers("/zahtjev/new").hasAuthority("KORISNIK")
				.antMatchers("/usluga/new").hasAuthority("ADMIN")
				.and().formLogin().successHandler(successHandler).loginPage("/login").and().logout().permitAll().and()
				.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/").and()
				.exceptionHandling().accessDeniedPage("/access-denied");
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}

}