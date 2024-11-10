package cn.jx.jjvu.ssm.handler;


import com.alibaba.fastjson2.JSON;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@Component
public class MyAccessDeniedHandler implements AccessDeniedHandler {
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        httpServletResponse.setContentType("application/json;charset=utf-8");
        httpServletResponse.setCharacterEncoding("utf-8");
        PrintWriter out = null;
        out = httpServletResponse.getWriter();
        Map map = new HashMap();
        map.put("code", 403);
        map.put("msg", "权限不足，请联系管理员");
        out.write(JSON.toJSONString(map));
        out.flush();
        out.close();
    }
}
