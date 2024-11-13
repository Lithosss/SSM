package cn.jx.jjvu.ssm.web.controller;

import cn.jx.jjvu.ssm.domain.entity.Sys_Menu;
import cn.jx.jjvu.ssm.domain.Result;
import cn.jx.jjvu.ssm.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/menuController")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @RequestMapping("/toAddMenu")
    public String toAddMenu(Model model) {

        List<Sys_Menu> menus = menuService.findAllMenu();
        model.addAttribute("menus", menus);

        return "f:/WEB-INF/admin/addmenu.jsp";
    }

    @RequestMapping("/addMenu")
    @ResponseBody
    public Result<Sys_Menu> addMenu(@RequestBody Sys_Menu menu) {


        Result<Sys_Menu> result = new Result<>();
        menuService.addMenu(menu);
        result.setCode(200);
        result.setMessage("菜单添加成功");
        return result;


    }

    @RequestMapping("/manageMenu")
    @ResponseBody
    public Result<List<Sys_Menu>> manageMenu() {


        List<Sys_Menu> list = menuService.findAllMenu();
        Result<List<Sys_Menu>> result = new Result<>();
        result.setCode(200);
        result.setMessage("成功");
        result.setData(list);

        return result;
    }

    @RequestMapping("/delMenu")
    @ResponseBody
    public Result<?> delMenu(Integer id) {

        menuService.delMenuById(id);

        Result<?> result = new Result<>();
        result.setCode(200);
        result.setMessage("success");

        return result;
    }

    @RequestMapping("/toEditMenu")
    @ResponseBody
    public Result<Sys_Menu> toEditMenu(Integer id) {

        Sys_Menu menu = menuService.findMenuById(id);

        Result<Sys_Menu> result = new Result<>();
        result.setCode(200);
        result.setMessage("success");
        result.setData(menu);


        return result;
    }

    @RequestMapping("/toEditDownMenu")
    @ResponseBody
    public Result<Sys_Menu> toEditDownMenu(@RequestBody Sys_Menu menu) {


        Sys_Menu menu1 = menuService.findDownMenuByID(menu);

        Result<Sys_Menu> result = new Result<>();
        result.setCode(200);
        result.setMessage("success");
        result.setData(menu1);


        return result;
    }

    @RequestMapping("/editMenu")
    @ResponseBody
    public Result<Sys_Menu> editMenu(@RequestBody Sys_Menu menu) {


        menuService.editMenu(menu);

        Result<Sys_Menu> result = new Result<>();
        result.setCode(200);
        result.setMessage("修改成功");
        result.setData(menu);
        return result;

    }



    @RequestMapping("/manageDownMenu")
    @ResponseBody
    public Result<List<Sys_Menu>> manageDownMenu(Integer id) {

        List<Sys_Menu> list = menuService.findAllDownMenu(id);
        Result<List<Sys_Menu>> result = new Result<>();
        result.setCode(200);
        result.setMessage("success");
        result.setData(list);

        return result;
    }



}
