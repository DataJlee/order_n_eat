package com.orderneat.orderneat.infrastructure.auth;

import com.orderneat.orderneat.exception.auth.ExpiredTokenException;
import com.orderneat.orderneat.exception.auth.InvalidTokenException;
import io.jsonwebtoken.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.Date;
import java.util.Map;


@Component
@RequiredArgsConstructor
public class JwtUtils {

    private final String secretKey = "dafeafjaieaghi213113ihhdfiaodhfaievbaevuahheiahrueha4ueaeahuilh2314iu15r";
    private final long expireLength = 30;
    private final JwtParser jwtParser;


    public JwtUtils(){
        this.jwtParser = Jwts.parser().setSigningKey(secretKey);
    }

    public String createToken(Map<String, Object> payload){
        Claims claims = Jwts.claims(payload);
        Date currentTime = new Date();
        Date validThrough = new Date(currentTime.getTime() + expireLength);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(currentTime)
                .setExpiration(validThrough)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    public void validateToken(String token){
        try{
            jwtParser.parseClaimsJwt(token);
        }catch (ExpiredJwtException e){
            throw new ExpiredTokenException();
        }catch (JwtException e){
            throw new InvalidTokenException();
        }
    }

    public String getPayload(String token){
        return jwtParser.parseClaimsJwt(token).getBody().getSubject();
    }

    public static PayloadBuilder payloadBuilder(){
        return new PayloadBuilder();
    }

    public static class PayloadBuilder{

        private final Claims claims;

        private PayloadBuilder(){
            this.claims = Jwts.claims();
        }

        public PayloadBuilder setSubject(String subject){
            claims.setSubject(subject);
            return this;
        }

        public Map<String, Object> build(){
            return claims;
        }
    }


}
