package cn.jx.jjvu.ssm.utils;


import cn.jx.jjvu.ssm.domain.LoginUser;
import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.JSONWriter;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.*;

import static cn.jx.jjvu.ssm.constants.OtherConstants.TOKEN_SITE;

@Component
public class JwtUtils {

    private static final String JWT_key = "imstest";

    private static final Long JWT_TTL=60*60*1000L;


    public static String getUUID(){
        String uuid = UUID.randomUUID().toString();
        return uuid;
    }

    public static String createJWT(LoginUser user,Long ttlMillis){
        JwtBuilder builder = getJwtBuilder(user,ttlMillis,getUUID());
        return builder.compact();
    }



    private static JwtBuilder getJwtBuilder(LoginUser user, Long ttlMillis, String uuid) {
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
                .setSubject(user.toString())
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
                .setSigningKey(JWT_key)
                .parseClaimsJwt(jwt)
                .getBody();
    }



}
