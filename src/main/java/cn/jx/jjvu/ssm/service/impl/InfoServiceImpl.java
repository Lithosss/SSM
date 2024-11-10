package cn.jx.jjvu.ssm.service.impl;

import cn.jx.jjvu.ssm.dao.InfoDao;
import cn.jx.jjvu.ssm.domain.entity.Sys_Info;
import cn.jx.jjvu.ssm.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("infoService")
public class InfoServiceImpl implements InfoService {

    @Autowired
    private InfoDao infoDao ;

    public void addInfo(Sys_Info info) {
        infoDao.addInfo(info);
    }


    public List<Sys_Info> findAllInfo() {
        return infoDao.findAllInfo();

    }


    public void delInfoById(Integer id) {
        infoDao.delInfoById(id);
    }


    public Sys_Info findInfoById(Integer id) {
        return infoDao.findInfoById(id);
    }


    public void editInfo(Sys_Info info) {
        infoDao.editInfo(info);
    }


    public List<Sys_Info> findAllInfoByParentId(Integer id, String type) {
        List<Sys_Info> infos = null;
        if (type.equals("menu")) {
            infos = infoDao.findAllInfoByParentId(id);
        } else if (type.equals("down")) {
            infos = infoDao.findAllInfoByMenuId(id);
        }
        return infos;
    }


    public List<Sys_Info> findSpan1info() {
        return infoDao.findSpan1info();
    }


}
