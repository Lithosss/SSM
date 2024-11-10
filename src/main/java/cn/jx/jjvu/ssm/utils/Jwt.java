package cn.jx.jjvu.ssm.utils;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.impl.DefaultJwtBuilder;
import org.junit.Test;

import java.util.Date;

public class Jwt {

    @Test
    public void Jwt(){
        JwtBuilder jwtBuilder =new DefaultJwtBuilder();
        jwtBuilder.setIssuedAt(new Date());
        jwtBuilder.setExpiration(new Date(System.currentTimeMillis()+1000*60*60*24));
        String token = jwtBuilder.compact();
        System.out.println(token);
    }
}
