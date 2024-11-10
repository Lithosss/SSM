package cn.jx.jjvu.ssm.handler;

import com.alibaba.fastjson.JSON;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@Component
public class LoginFailureHandler implements AuthenticationFailureHandler {
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        httpServletResponse.setContentType("appliction/json;charset=utf-8");
        httpServletResponse.setCharacterEncoding("utf-8");
        PrintWriter out = null;
        out = httpServletResponse.getWriter();
        Map map = new HashMap();
        map.put("code", 500);
        map.put("msg", "登录失败");
        out.write(JSON.toJSONString(map));
        out.flush();
        out.close();
    }
}
