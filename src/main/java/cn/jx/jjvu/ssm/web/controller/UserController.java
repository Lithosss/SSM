package cn.jx.jjvu.ssm.web.controller;


import cn.jx.jjvu.ssm.domain.Result;
import cn.jx.jjvu.ssm.domain.VO.AuthUserVO;
import cn.jx.jjvu.ssm.domain.entity.Sys_User;
import cn.jx.jjvu.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/userController")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    @ResponseBody
    public Result login(@RequestBody Sys_User sysUser) {

        Result result = new Result();
        AuthUserVO authUserVO =  userService.login(sysUser);
        result.setCode(200);
        result.setMessage("success");
        result.setData(authUserVO);
        return result;

    }

    @RequestMapping("/manageUser")
    @ResponseBody
    public Result manageUser() {

        List list = userService.findAllUser();

        Result result = new Result();
        result.setCode(200);
        result.setMessage("成功");
        result.setData(list);
        return result;

    }

    @RequestMapping("/addUser")
    @ResponseBody
    public Result addUser(Sys_User user) {

        Map map = userService.addUser(user);
        Result result = new Result();
        if (user.getUsername().isEmpty() || user.getPassword().isEmpty()) {
            result.setCode(500);
            result.setMessage("用户名或密码为空");
            result.setData(user);
            return result;

        }
        if (map != null && !map.isEmpty()) {
            result.setCode(500);
            result.setMessage("添加失败");
            result.setData(user);
            return result;

        } else {
            result.setCode(200);
            result.setMessage("添加成功");
            return result;
        }

    }

    @RequestMapping("/delUser")
    @ResponseBody
    public Result delUser(Integer id) {

        userService.delUserById(id);
        Result result = new Result();
        result.setCode(200);
        result.setMessage("成功");
        return result;
    }

    @RequestMapping("/toEditUser")
    @ResponseBody
    public Result<Sys_User> toEditUser(Integer id) {

        Sys_User user = userService.findUserById(id);
        Result<Sys_User> result = new Result<>();
        result.setCode(200);
        result.setMessage("修改成功");
        result.setData(user);

        return result;
    }

    @RequestMapping("/editUser")
    @ResponseBody
    public Result<Sys_User> editUser(Sys_User user) {


        Result<Sys_User> result = new Result<>();

        Map map = userService.editUser(user);
        if (map == null || map.isEmpty()) {
            result.setCode(200);
            result.setMessage("修改成功");
        } else {
            result.setCode(500);
            result.setMessage("修改失败");
        }
        return result;

    }
}
