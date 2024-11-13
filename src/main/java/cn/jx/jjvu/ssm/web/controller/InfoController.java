package cn.jx.jjvu.ssm.web.controller;


import cn.jx.jjvu.ssm.domain.entity.Sys_Info;
import cn.jx.jjvu.ssm.domain.Result;
import cn.jx.jjvu.ssm.service.InfoService;
import cn.jx.jjvu.ssm.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/infoController")
public class InfoController {
    @Autowired
    private MenuService menuService;
    @Autowired
    private InfoService infoService;


    @RequestMapping("/addInfo")
    public Result addInfo(Sys_Info info) {

        Result result = new Result();
        infoService.addInfo(info);
        result.setCode(200);
        result.setMessage("成功");

        return result;
    }

    @RequestMapping("/manageInfo")
    public Result manageInfo() {

        Result result = new Result();
        List<Sys_Info> list = infoService.findAllInfo();

        result.setCode(200);
        result.setMessage("成功");
        result.setData(list);

        return result;
    }

    @RequestMapping("/delInfo")
    public Result delInfo(Integer id) {

        infoService.delInfoById(id);
        Result result = new Result();
        result.setCode(200);
        result.setMessage("删除成功");

        return result;
    }

    @RequestMapping("/toEditInfo")
    public Result toEditInfo(Integer id) {

        Sys_Info info = infoService.findInfoById(id);

        Result result = new Result();
        result.setCode(200);
        result.setMessage("success");
        result.setData(info);

        return result;
    }

    @RequestMapping("/editInfo")
    public Result editInfo(Sys_Info info) {

        infoService.editInfo(info);
        Result result = new Result();
        result.setCode(200);
        result.setMessage("修改成功");
        return result;
    }

}
