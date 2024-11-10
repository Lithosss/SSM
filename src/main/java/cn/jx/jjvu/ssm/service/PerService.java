package cn.jx.jjvu.ssm.service;

import cn.jx.jjvu.ssm.domain.entity.Sys_Per;

import java.util.List;

public interface PerService  {

    List<Sys_Per> findAllPer();

    List<Sys_Per> findAllDownPer(Integer id);

    void delPerById(Integer id);

    void addPer(Sys_Per per);

    void addDownPer(Sys_Per per);

    Sys_Per findPerById(Integer id);

    void updatePer(Sys_Per sysPer);
}
