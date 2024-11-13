package cn.jx.jjvu.ssm.web.controller;


import cn.jx.jjvu.ssm.domain.entity.Sys_Info;

import cn.jx.jjvu.ssm.domain.Result;
import cn.jx.jjvu.ssm.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/indexController")
public class IndexController {
    //打开主页
    @Autowired
    private InfoService infoService;


    @RequestMapping("/toIndex")
    public Result toIndex(Model model) {

        List<Sys_Info> info1 = infoService.findSpan1info();
        Result result =new Result();
        result.setCode(200);
        result.setMessage("成功");
        result.setData(info1);

        return result;
    }



    @RequestMapping("/allNews")
    public Result allNews(Integer id, String type) {

        List<Sys_Info> infos = infoService.findAllInfoByParentId(id, type);
        Result result=new Result();
        result.setCode(300);
        result.setMessage("成功");
        result.setData(infos);

        return result;
    }

    @RequestMapping("/showNews")
    public Result showNews(Integer id) {

        Sys_Info info = infoService.findInfoById(id);
        Result result =new Result();
        result.setCode(200);
        result.setMessage("成功");
        result.setData(info);

        return result;
    }
}
