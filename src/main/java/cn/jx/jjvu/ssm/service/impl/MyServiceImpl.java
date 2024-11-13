package cn.jx.jjvu.ssm.service.impl;

import cn.jx.jjvu.ssm.service.MyService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

@Service("myServiceImpl")
public class MyServiceImpl implements MyService {
    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {
        System.out.println(request.getRequestURI());
        Object obj=authentication.getPrincipal();
        if(obj instanceof UserDetails){
            UserDetails userDetails=(UserDetails)obj;
            Collection<? extends GrantedAuthority> authorities=userDetails.getAuthorities();
            return authorities.contains(new SimpleGrantedAuthority(request.getRequestURI()));   //      /adduser
        }
        return false;
    }
}
