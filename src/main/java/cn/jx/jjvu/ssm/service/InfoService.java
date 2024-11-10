package cn.jx.jjvu.ssm.service;


import cn.jx.jjvu.ssm.domain.entity.Sys_Info;

import java.util.List;

public interface InfoService {
    void addInfo(Sys_Info info);

    List<Sys_Info> findAllInfo();

    void delInfoById(Integer id);

    Sys_Info findInfoById(Integer id);

    void editInfo(Sys_Info info);

    List<Sys_Info> findAllInfoByParentId(Integer id, String type);

    List<Sys_Info> findSpan1info();


}
