package cn.jx.jjvu.ssm.web.controller;

import cn.jx.jjvu.ssm.domain.Result;
import cn.jx.jjvu.ssm.domain.entity.Sys_Info;
import cn.jx.jjvu.ssm.domain.entity.Sys_Menu;
import cn.jx.jjvu.ssm.domain.entity.Sys_Per;
import cn.jx.jjvu.ssm.service.PerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/perController")
public class PerController {
    @Autowired
    private PerService perService;

    @RequestMapping("/managePer")
    public Result<List<Sys_Per>> managePer() {

        List<Sys_Per> list = perService.findAllPer();
        Result<List<Sys_Per>> result = new Result<>();
        result.setCode(200);
        result.setMessage("成功");
        result.setData(list);

        return result;
    }


    @RequestMapping("/manageDownPer")
    public Result<List<Sys_Per>> manageDownPer(Integer id) {

        List<Sys_Per> list = perService.findAllDownPer(id);
        Result<List<Sys_Per>> result = new Result<>();
        result.setCode(200);
        result.setMessage("success");
        result.setData(list);

        return result;
    }
    @RequestMapping("/delPer")
    public Result<?> delPer(Integer id) {

        perService.delPerById(id);
        Result<?> result = new Result<>();
        result.setCode(200);
        result.setMessage("success");

        return result;
    }

    @RequestMapping("/addPer")
    @ResponseBody
    public Result addPer(Sys_Per per) {

        Result result = new Result();
        per.setParentid(0);

        perService.addPer(per);
        result.setCode(200);
        result.setMessage("成功");

        return result;
    }


    @RequestMapping("/addDownPer")
    public Result addDownPer(Sys_Per sysPer) {
        Result result = new Result();
        perService.addDownPer(sysPer);

        result.setCode(200);
        result.setMessage("成功");

        return result;
    }

    @RequestMapping("/toEditPer")
    public Result toEditPer(Integer id) {
        Result result = new Result();
        Sys_Per sysPer= perService.findPerById(id);

        result.setCode(200);
        result.setMessage("success");
        result.setData(sysPer);
        return result;
    }

    @RequestMapping("/editPer")
    public Result editPer(Sys_Per sysPer) {

        Result result = new Result();

        perService.updatePer(sysPer);

        result.setCode(200);
        result.setMessage("success");
        return result;
    }






}
