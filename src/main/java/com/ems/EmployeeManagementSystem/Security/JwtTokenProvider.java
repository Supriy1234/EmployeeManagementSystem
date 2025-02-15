/*
 * package com.ems.EmployeeManagementSystem.Security;
 * 
 * import io.jsonwebtoken.*; import io.jsonwebtoken.security.Keys; import
 * org.springframework.beans.factory.annotation.Value; import
 * org.springframework.security.core.Authentication; import
 * org.springframework.stereotype.Component;
 * 
 * import java.nio.charset.StandardCharsets; import java.security.Key; import
 * java.util.Date;
 * 
 * @Component public class JwtTokenProvider {
 * 
 * private final Key key; private final long jwtExpirationMs;
 * 
 * public JwtTokenProvider(
 * 
 * @Value("${jwt.secret}") String secretKey,
 * 
 * @Value("${jwt.expiration}") long expirationMs) { if (secretKey.length() < 32)
 * { throw new
 * IllegalArgumentException("JWT secret key must be at least 32 characters long!"
 * ); } this.key =
 * Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));
 * this.jwtExpirationMs = expirationMs; }
 * 
 * public String generateToken(Authentication authentication) { return
 * Jwts.builder() .setSubject(authentication.getName()) .setIssuedAt(new Date())
 * .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationMs))
 * .signWith(key, SignatureAlgorithm.HS256) .compact(); }
 * 
 * public String getUsernameFromToken(String token) { return
 * Jwts.parserBuilder() .setSigningKey(key) .build() .parseClaimsJws(token)
 * .getBody() .getSubject(); }
 * 
 * public boolean validateToken(String token) { try {
 * Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token); return
 * true; } catch (JwtException e) { System.out.println("Invalid JWT Token: " +
 * e.getMessage()); return false; } } }
 */