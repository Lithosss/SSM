package cn.jx.jjvu.ssm.web.controller;


import cn.jx.jjvu.ssm.domain.entity.Sys_Info;
import cn.jx.jjvu.ssm.domain.Result;
import cn.jx.jjvu.ssm.service.InfoService;
import cn.jx.jjvu.ssm.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/infoController")
public class InfoController {
    @Autowired
    private MenuService menuService;
    @Autowired
    private InfoService infoService;


    @RequestMapping("/addInfo")
    @ResponseBody
    public Result addInfo(Sys_Info info) {

        Result result = new Result();
        infoService.addInfo(info);
        result.setCode(200);
        result.setMessage("成功");

        return result;
    }

    @RequestMapping("/manageInfo")
    @ResponseBody
    public Result manageInfo() {

        Result result = new Result();
        List<Sys_Info> list = infoService.findAllInfo();

        result.setCode(200);
        result.setMessage("成功");
        result.setData(list);

        return result;
    }

    @RequestMapping("/delInfo")
    @ResponseBody
    public Result delInfo(Integer id) {

        infoService.delInfoById(id);
        Result result = new Result();
        result.setCode(200);
        result.setMessage("删除成功");

        return result;
    }

    @RequestMapping("/toEditInfo")
    @ResponseBody
    public Result toEditInfo(Integer id) {

        Sys_Info info = infoService.findInfoById(id);

        Result result = new Result();
        result.setCode(200);
        result.setMessage("success");
        result.setData(info);

        return result;
    }

    @RequestMapping("/editInfo")
    @ResponseBody
    public Result editInfo(Sys_Info info) {

        infoService.editInfo(info);
        Result result = new Result();
        result.setCode(200);
        result.setMessage("修改成功");
        return result;
    }

}
