package com.anddie.authenticate.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Component
public class JwtTokenUtil extends GlobalLogger {
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

    private static final String BEARER = "Bearer ";
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

    /**
     * Validate token
     * @param token The token
     * @param userId The user's id
     * @return
     */
    public boolean validateToken(final String token,String userId) {
        try {
            if(!token.startsWith(BEARER)){
                throw new JWTVerificationException("Invalid JWT token");
            }
            final String cleanedToken = token.substring(7);
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer(issuer)
                    .build();
            DecodedJWT jwt = verifier.verify(cleanedToken);
            String id = jwt.getClaim("id").asString();
            return (id.equals(userId) && !isTokenExpired(jwt));
        }catch (JWTVerificationException e){
            logger.error("Validate token fail{}",e,e.getMessage());
            return false;
        }
    }

    /**
     * Is validate token expired
     * @param jwt
     * @return
     */
    private boolean isTokenExpired(DecodedJWT jwt) {
        return jwt.getExpiresAt().before(new Date());
    }
}
