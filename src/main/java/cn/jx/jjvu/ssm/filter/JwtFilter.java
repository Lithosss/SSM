package cn.jx.jjvu.ssm.filter;

import cn.jx.jjvu.ssm.domain.LoginUser;
import cn.jx.jjvu.ssm.utils.JwtUtils;
import com.alibaba.fastjson2.JSON;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.equals("/SSM/userController/login")) {
            filterChain.doFilter(request, response);
            return;
        }


        String token = request.getHeader("Authorization");

        if (!StringUtils.hasLength(token)) {
            throw new RuntimeException("Authorization header is empty");

        }
        LoginUser loginUser = null;
        try {
            Claims claims = JwtUtils.parseJWT(token);
            String jsonLoginUser = claims.getSubject();
               loginUser=JSON.parseObject(jsonLoginUser, LoginUser.class);

        }catch (Exception e) {
            throw new RuntimeException(e);
        }
        UsernamePasswordAuthenticationToken authenticationToken =new UsernamePasswordAuthenticationToken(loginUser,null,null);
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        filterChain.doFilter(request, response);

    }
}
