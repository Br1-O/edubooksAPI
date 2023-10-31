package com.br1.edubooks.model.infrastructure.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.br1.edubooks.model.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class JWT_tokenService {

    //env variable
        @Value("${api.security.secret}")
        private String JWTSecret;

    //generate JWT
        public String generateJWT(User user){
            try {
                Algorithm algorithm = Algorithm.HMAC256(JWTSecret);
                return JWT.create()
                        .withIssuer("edubooks")
                        .withSubject(user.getUsername())
                        .withClaim("id", user.getId())
                        .withExpiresAt(expiresAt(2))
                        .sign(algorithm);
            } catch (JWTCreationException exception){
                return "¡Error de autentificación! (no se pudo generar JWT)";
            }
        }

    //generate expiration date
        public Instant expiresAt(int hours){
            return LocalDateTime.now().plusHours(hours).toInstant(ZoneOffset.of("-05:00"));
        }

    //get username from JWT
        public String getSubject(String token) {

            if(token== null){
                throw new RuntimeException("¡Error de autentificación! (JWT es requerido)");
            }

            DecodedJWT verifier;

            try {
                Algorithm algorithm = Algorithm.HMAC256(JWTSecret);
                verifier = JWT.require(algorithm)
                        .withIssuer("edubooks")
                        .build()
                        .verify(token);
                verifier.getSubject();
            } catch (JWTVerificationException exception) {
                return "¡Error de autentificación! ¡No se pudo determinar al usuario a traves del JWT!";
            }

            if (verifier.getSubject() == null) {
                throw new RuntimeException("¡Error de autentificación! ¡El usuario no puede ser nulo en el JWT!");
            }
            return verifier.getSubject();
        }

}
