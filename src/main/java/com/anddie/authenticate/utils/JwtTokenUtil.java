package com.anddie.authenticate.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

@Component
public class JwtTokenUtil {
    /**
     * JWT Secret key
     */
    @Value("${jwt.secret}")
    private String secret;

    /**
     * Token expiration time
     */
    @Value("${jwt.expiration}")
    private Long expiration;

    /**
     * Issuer of  token
     */
    @Value("${jwt.issuer}")
    private String issuer;

    /**
     * Generate JWT Token
     * @param id The user's id
     * @param roleCode The user's role code
     * @return The JWT token
     */
    public String generateToken(final String id,final Integer roleCode) {
        final ZonedDateTime now = ZonedDateTime.now();
        final ZonedDateTime exp = now.plus(expiration, ChronoUnit.MINUTES);
        return JWT.create()
                .withClaim("id", id)
                .withClaim("roleCode",roleCode)
                .withIssuer(issuer)
                .withNotBefore(now.toInstant())
                .withExpiresAt(exp.toInstant())
                .sign(Algorithm.HMAC256(secret));
    }
}
