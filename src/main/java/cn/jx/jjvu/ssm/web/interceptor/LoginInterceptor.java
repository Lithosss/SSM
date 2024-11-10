package cn.jx.jjvu.ssm.web.interceptor;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
       StringBuffer url = request.getRequestURL();
       if(url.indexOf("/toLogin")>0 || url.indexOf("login")>0){
           return true;
       }
       HttpSession session = request.getSession();
       if(session.getAttribute("user")!=null){
           return true;
       }
       request.setAttribute("msg" ,"您未登录");
       response.sendRedirect("../index.html");
       return false;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {

    }
}
