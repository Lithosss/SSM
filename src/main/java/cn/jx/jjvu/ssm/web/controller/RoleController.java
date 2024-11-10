package cn.jx.jjvu.ssm.web.controller;


import cn.jx.jjvu.ssm.domain.Result;
import cn.jx.jjvu.ssm.domain.entity.Sys_Per;
import cn.jx.jjvu.ssm.domain.entity.Sys_Role;
import cn.jx.jjvu.ssm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequestMapping("/roleController")
@RestController
public class RoleController {

    @Autowired
    private RoleService roleService;


    @RequestMapping("/findAllRole")
    public Result findAllRole() {

        Result result = new Result();
        List<Sys_Role> allRole = roleService.findAllRole();

        result.setCode(200);
        result.setData(allRole);
        result.setMessage("success");

        return result;
    }

    @RequestMapping("/addRole")
    public Result addRole(Sys_Role role) {

        Result result = new Result();
        roleService.addRole(role);

        result.setCode(200);
        result.setMessage("success");

        return result;
    }

    @RequestMapping("/delRole")
    public Result delRole(Integer id) {

        Result result = new Result();
        roleService.delRole(id);

        result.setCode(200);
        result.setMessage("success");

        return result;
    }



    @RequestMapping("/toEditRolePer")
    public Result toEditRolePer(Integer roleId) {
       List<Sys_Per> sysPers =roleService.toEditRolePer(roleId);
        Result result = new Result();
        result.setCode(200);
        result.setData(sysPers);
        result.setMessage("success");
        return result;

    }

    @RequestMapping("/editRolePer")
    public Result editRolePer(Integer roleId,Integer[] perId) {
        roleService.editRolePer(roleId,perId);
        Result result = new Result();
        result.setCode(200);
        result.setMessage("success");


        return result;
    }

}
