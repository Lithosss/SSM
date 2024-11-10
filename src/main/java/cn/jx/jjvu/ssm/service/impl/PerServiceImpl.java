package cn.jx.jjvu.ssm.service.impl;

import cn.jx.jjvu.ssm.dao.PerDao;
import cn.jx.jjvu.ssm.domain.entity.Sys_Per;
import cn.jx.jjvu.ssm.service.PerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service("perServiceImpl")
public class PerServiceImpl implements PerService {

    @Autowired
    private PerDao perDao;


    public List<Sys_Per> findAllPer() {
        return perDao.findAllPer();
    }

    @Override
    public List<Sys_Per> findAllDownPer(Integer id) {
        return perDao.findAllDownPer(id);
    }

    @Override
    public void delPerById(Integer id) {
         perDao.delPerById(id);
    }

    @Override
    public void addPer(Sys_Per per) {
        perDao.addPer(per);
    }

    @Override
    public void addDownPer(Sys_Per per) {
        perDao.addPer(per);
    }

    @Override
    public Sys_Per findPerById(Integer id) {
        return perDao.findPerById(id);
    }

    @Override
    public void updatePer(Sys_Per sysPer) {
        perDao.updatePer(sysPer);
    }
}
