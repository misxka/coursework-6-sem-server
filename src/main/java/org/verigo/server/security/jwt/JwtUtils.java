package org.verigo.server.security.jwt;

import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.verigo.server.security.services.CustomUserDetails;

import java.util.Date;

@Component
public class JwtUtils {
    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

    @Value("${app.jwtSecret}")
    private String jwtSecret;

    @Value("${app.jwtExpiresIn}")
    private int jwtExpirationMs;
    public String generateJwtToken(Authentication authentication) {
        CustomUserDetails userPrincipal = (CustomUserDetails) authentication.getPrincipal();
        return Jwts.builder().setSubject((userPrincipal.getUsername())).setIssuedAt(new Date())
            .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs)).signWith(SignatureAlgorithm.HS512, jwtSecret)
            .compact();
    }

    public String getUserNameFromJwtToken(String token) {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException e) {
            logger.error("Неверная JWT подпись", e.getMessage());
        } catch (MalformedJwtException e) {
            logger.error("Неверный JWT токен", e.getMessage());
        } catch (ExpiredJwtException e) {
            logger.error("Срок действия JWT токена истёк", e.getMessage());
        } catch (UnsupportedJwtException e) {
            logger.error("Неподдерживаемый JWT токен", e.getMessage());
        } catch (IllegalArgumentException e) {
            logger.error("Неверный формат токена", e.getMessage());
        }
        return false;
    }
}
