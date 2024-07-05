package me.sisyphusj.community.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;
import me.sisyphusj.community.app.security.CustomAccessDeniedHandler;
import me.sisyphusj.community.app.security.CustomAuthenticationEntryPoint;
import me.sisyphusj.community.app.security.CustomAuthenticationFailureHandler;
import me.sisyphusj.community.app.security.CustomAuthenticationSuccessHandler;
import me.sisyphusj.community.app.security.CustomLogoutHandler;

@EnableWebSecurity
@RequiredArgsConstructor
@Configuration
public class SecurityConfig {

	private final String[] permittedUrls = {"/", "/auth/signup", "/auth/register", "/auth/login", "/auth/signin", "/WEB-INF/views/**", "/error"};

	private final CustomAuthenticationEntryPoint authEntryPoint;

	private final CustomAccessDeniedHandler accessDeniedHandler;

	private final CustomAuthenticationFailureHandler failureHandler;

	private final CustomAuthenticationSuccessHandler successHandler;

	private final CustomLogoutHandler customLogoutHandler;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests(
				authorize -> authorize
					.requestMatchers(permittedUrls).permitAll()
					.anyRequest()
					.authenticated()
			)

			.formLogin(
				form -> form
					.loginPage("/auth/login")
					.loginProcessingUrl("/auth/signin")
					.successHandler(successHandler)
					.failureHandler(failureHandler)
					.permitAll()
			)

			.logout(
				logout -> logout
					.logoutUrl("/auth/logout")
					.logoutSuccessUrl("/")
					.addLogoutHandler(customLogoutHandler)
			)

			.exceptionHandling(
				exceptionHandling -> exceptionHandling
					.accessDeniedHandler(accessDeniedHandler)
					.authenticationEntryPoint(authEntryPoint)
			);

		return http.build();
	}

}
