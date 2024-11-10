package cn.jx.jjvu.ssm.web.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@ControllerAdvice
public class ExceptionAdvice {
    @ExceptionHandler(MyException.class)
    public ModelAndView doMyException(MyException ex) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg",ex.getMessage());
        modelAndView.setViewName("error");
        return modelAndView;
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView doOtherException(Exception ex) throws IOException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg","网络异常！");
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
