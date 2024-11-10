package cn.jx.jjvu.ssm.service;


import cn.jx.jjvu.ssm.domain.entity.Sys_Menu;

import java.util.List;

public interface MenuService {
     List<Sys_Menu> findAllMenu();

    void addMenu(Sys_Menu menu);

    void delMenuById(Integer id);

    Sys_Menu findMenuById(Integer id);

    void editMenu(Sys_Menu menu);

    List<Sys_Menu> findAllDownMenu(Integer id);

    Sys_Menu findDownMenuByID(Sys_Menu menu);

}
