package cn.jx.jjvu.ssm.utils;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.*;



@Component
public class JwtUtils {

    private static final String JWT_key = "imstest";

    private static final Long JWT_TTL=60*60*1000L;


    public static String getUUID(){
        String uuid = UUID.randomUUID().toString();
        return uuid;
    }

    public static String createJWT(String s,Long ttlMillis){
        JwtBuilder builder = getJwtBuilder(s,ttlMillis,getUUID());
        return builder.compact();
    }



    private static JwtBuilder getJwtBuilder(String s, Long ttlMillis, String uuid) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        SecretKey secretKey =generalKey();
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        if(ttlMillis==null){
            ttlMillis = JWT_TTL;
        }
        long expMillis = nowMillis + ttlMillis;
        Date exp = new Date(expMillis);
        return Jwts.builder()
                .setSubject(s.toString())
                .signWith(signatureAlgorithm, secretKey)
                .setExpiration(exp);
    }

    private static SecretKey generalKey() {
        byte[] encodedKey = Base64.getDecoder().decode(JWT_key);
        SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
        return key;
    }

    public static Claims parseJWT(String jwt){
        SecretKey secretKey = generalKey();
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(jwt)
                .getBody();
    }



}
