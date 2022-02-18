package com.sdu.supportteach.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import java.util.Date;
@Slf4j
@Data
@Component
public class JwtUtil {
    private String secret = "f4e2dgh5203dg348adas86b67cde581c0f92123b5";
    private long expire = 604800;
    private String header = "token";

    public String generateToken(long user_id){
        Date nowDate = new Date();
        //过期时间
        Date expireDate = new Date(nowDate.getTime() + expire * 1000);
        return Jwts.builder()
                .setHeaderParam("typ","JWT")
                .setSubject(user_id+"")
                .setIssuedAt(nowDate)
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }
    public Claims getClaimsByToken(String token){
        try{
            return Jwts.parser().setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        }catch (Exception e){
            log.debug("Validation error", e);
            return null;
        }
    }
    public boolean isTokenExpired(Date expiration){
        return expiration.before(new Date());
    }
}
