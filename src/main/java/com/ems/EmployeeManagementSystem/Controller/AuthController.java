/*
 * package com.ems.EmployeeManagementSystem.Controller;
 * 
 * import com.ems.EmployeeManagementSystem.DTO.LoginRequest; import
 * com.ems.EmployeeManagementSystem.DTO.JwtResponse; import
 * com.ems.EmployeeManagementSystem.Repository.UserRepository; import
 * com.ems.EmployeeManagementSystem.Security.JwtTokenProvider; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.security.authentication.AuthenticationManager; import
 * org.springframework.security.authentication.
 * UsernamePasswordAuthenticationToken; import
 * org.springframework.security.core.Authentication; import
 * org.springframework.security.core.context.SecurityContextHolder; import
 * org.springframework.web.bind.annotation.*;
 * 
 * @RestController
 * 
 * @RequestMapping("/api/auth") public class AuthController {
 * 
 * private final AuthenticationManager authenticationManager; private final
 * JwtTokenProvider jwtTokenProvider; private final UserRepository
 * userRepository;
 * 
 * public AuthController(AuthenticationManager authenticationManager,
 * JwtTokenProvider jwtTokenProvider, UserRepository userRepository) {
 * this.authenticationManager = authenticationManager; this.jwtTokenProvider =
 * jwtTokenProvider; this.userRepository = userRepository; }
 * 
 * @PostMapping("/login") public ResponseEntity<?> authenticateUser(@RequestBody
 * LoginRequest loginRequest) { Authentication authentication =
 * authenticationManager.authenticate( new UsernamePasswordAuthenticationToken(
 * loginRequest.getUsername(), loginRequest.getPassword() ) );
 * 
 * SecurityContextHolder.getContext().setAuthentication(authentication); String
 * token = jwtTokenProvider.generateToken(authentication);
 * 
 * return ResponseEntity.ok(new JwtResponse(token)); } }
 */