package cn.jx.jjvu.ssm.service.impl;



import cn.jx.jjvu.ssm.dao.MenuDao;
import cn.jx.jjvu.ssm.domain.entity.Sys_Menu;
import cn.jx.jjvu.ssm.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("menuService")
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuDao menuDao ;

    public List<Sys_Menu> findAllMenu() {

        List<Sys_Menu> meaus = menuDao.findAllMenu();
        List<Sys_Menu> root = new ArrayList<Sys_Menu>();
        for (int i = 0; i < meaus.size(); i++) {
            Sys_Menu parent = meaus.get(i);
            if (parent.getParent_id() == 0) {
                root.add(parent);
            }
            List<Sys_Menu> childs = new ArrayList<Sys_Menu>();
            for (Sys_Menu meau : meaus) {
                if (meau.getParent_id() == parent.getId()) {
                    childs.add(meau);
                }

            }
            parent.setChildren(childs);
        }
        return root;
    }


    public void addMenu(Sys_Menu menu) {
        menuDao.addMenu(menu);
    }



    public void delMenuById(Integer id) {
        menuDao.delMenuById(id);
    }


    public Sys_Menu findMenuById(Integer id) {
        return menuDao.findMenuById(id);
    }


    public void editMenu(Sys_Menu menu) {
        menuDao.editMenu(menu);
    }


    public List<Sys_Menu> findAllDownMenu(Integer id) {
        return menuDao.findAllDownMenu(id);
    }

    @Override
    public Sys_Menu findDownMenuByID(Sys_Menu menu) {
        return menuDao.findDownMenuById(menu);
    }
}
