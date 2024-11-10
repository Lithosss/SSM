package cn.jx.jjvu.ssm.service;


import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

public interface MyService {
     boolean hasPermission(HttpServletRequest httpServletRequest, Authentication authentication);
}
