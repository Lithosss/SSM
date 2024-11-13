package cn.jx.jjvu.ssm.web.controller;

import cn.jx.jjvu.ssm.domain.RequestDTO;
import cn.jx.jjvu.ssm.domain.Result;
import cn.jx.jjvu.ssm.domain.entity.Sys_Per;
import cn.jx.jjvu.ssm.domain.entity.Sys_User;
import cn.jx.jjvu.ssm.service.PerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
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
    public Result<List<Sys_Per>> manageDownPer(@RequestBody RequestDTO requestDTO) {
        Integer id = requestDTO.getId();
        List<Sys_Per> list = perService.findAllDownPer(id);
        Result<List<Sys_Per>> result = new Result<>();
        result.setCode(200);
        result.setMessage("success");
        result.setData(list);

        return result;
    }
    @RequestMapping("/delPer")
    public Result<?> delPer(@RequestBody RequestDTO requestDTO) {
        Integer id = requestDTO.getId();
        perService.delPerById(id);
        Result<?> result = new Result<>();
        result.setCode(200);
        result.setMessage("success");

        return result;
    }

    @RequestMapping("/addPer")
    public Result addPer(@RequestBody Sys_Per sysPer) {


        sysPer.setParentid(0);
        perService.addPer(sysPer);

        Result result = new Result();

        result.setCode(200);
        result.setMessage("成功");

        return result;
    }


    @RequestMapping("/addDownPer")
    public Result addDownPer(@RequestBody Sys_Per sysPer) {


        perService.addDownPer(sysPer);

        Result result = new Result();
        result.setCode(200);
        result.setMessage("成功");

        return result;
    }

    @RequestMapping("/toEditPer")
    public Result toEditPer(@RequestBody RequestDTO requestDTO) {

        Integer id = requestDTO.getId();
        Sys_Per sysPer= perService.findPerById(id);

        Result result = new Result();
        result.setCode(200);
        result.setMessage("success");
        result.setData(sysPer);
        return result;
    }

    @RequestMapping("/editPer")
    public Result editPer(@RequestBody Sys_Per sysPer) {

        perService.updatePer(sysPer);

        Result result = new Result();
        result.setCode(200);
        result.setMessage("success");
        return result;
    }






}
