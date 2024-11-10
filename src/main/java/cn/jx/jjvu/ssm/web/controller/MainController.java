package cn.jx.jjvu.ssm.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mainController")
public class MainController {
    @RequestMapping("/top")
    public String top() {
        return "top";
    }

    @RequestMapping("/left")
    public String left() {
        return "left";
    }

    @RequestMapping("/menu")
    public String menu() {
        return "menu";
    }

    @RequestMapping("/main")
    public String main() {
        return "main";
    }
}
