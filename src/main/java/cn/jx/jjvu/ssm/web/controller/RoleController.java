package cn.jx.jjvu.ssm.web.controller;


import cn.jx.jjvu.ssm.domain.RequestDTO;
import cn.jx.jjvu.ssm.domain.Result;
import cn.jx.jjvu.ssm.domain.entity.Sys_Per;
import cn.jx.jjvu.ssm.domain.entity.Sys_Role;
import cn.jx.jjvu.ssm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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
    public Result addRole(@RequestBody RequestDTO requestDTO) {

        Sys_Role role = requestDTO.getSysRole();
        roleService.addRole(role);


        Result result = new Result();
        result.setCode(200);
        result.setMessage("success");

        return result;
    }

    @RequestMapping("/delRole")
    public Result delRole(@RequestBody RequestDTO requestDTO) {
        Integer id = requestDTO.getId();
        roleService.delRole(id);

        Result result = new Result();
        result.setCode(200);
        result.setMessage("success");

        return result;
    }



    @RequestMapping("/toEditRolePer")
    public Result toEditRolePer(@RequestBody RequestDTO requestDTO) {
        Integer id = requestDTO.getId();

        List<Sys_Per> sysPer =roleService.toEditRolePer(id);
        Result result = new Result();
        result.setCode(200);
        result.setData(sysPer);
        result.setMessage("success");
        return result;

    }

    @RequestMapping("/editRolePer")
    public Result editRolePer(@RequestBody RequestDTO requestDTO) {
        Integer id = requestDTO.getId();
        Integer[] idArrays = requestDTO.getIntegerArray();
        roleService.editRolePer(id,idArrays);
        Result result = new Result();
        result.setCode(200);
        result.setMessage("success");


        return result;
    }

}
