package com.ems.EmployeeManagementSystem.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

//To test api on Postman
@Configuration
public class SecurityConfig {

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
      http
          .csrf(csrf -> csrf.disable()) // Disable CSRF for Postman testing
          .authorizeHttpRequests(auth -> auth
              .requestMatchers("/h2-console/**").permitAll() // Allow H2 Console
              .anyRequest().permitAll() // ⚠ Allow all requests (For Testing Only)
          )
          .headers(headers -> headers
              .frameOptions(frame -> frame.disable()) // Allow frames (needed for H2)
          );

      return http.build();
  }
}

/*@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())  // Disable CSRF for stateless APIs
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/employees/saveEmp").hasRole("ADMIN") // Only ADMIN can add employees
                .requestMatchers("/employees/showAll").hasRole("ADMIN") // Only ADMIN can get all employees
                .requestMatchers("/employees/findById/{id}").hasAnyRole("ADMIN", "USER") // ADMIN & USER can view employee by ID
                .requestMatchers("/employees/updateEmp/{id}").hasRole("ADMIN") // Only ADMIN can update
                .requestMatchers("/employees/deleteById/{id}").hasRole("ADMIN") // Only ADMIN can delete
                .requestMatchers("/auth/login", "/auth/register").permitAll() // Allow authentication endpoints
                .anyRequest().authenticated()
            )
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)); // Use JWT-based authentication (stateless)

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
    	UserDetails user = User.withUsername("user")
    		    .password(passwordEncoder().encode("password"))
    		    .roles("USER")  // Spring converts this to "ROLE_USER"
    		    .build();

    		UserDetails admin = User.withUsername("admin")
    		    .password(passwordEncoder().encode("admin123"))
    		    .roles("ADMIN")  // Spring converts this to "ROLE_ADMIN"
    		    .build();
        return new InMemoryUserDetailsManager(user, admin);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Secure password storage
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}

@Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        .csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(auth -> auth.anyRequest().permitAll()) // Allow all requests
        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

    return http.build();
}
*/





