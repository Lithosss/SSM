package cn.jx.jjvu.ssm.service.impl;

import cn.jx.jjvu.ssm.dao.PerDao;
import cn.jx.jjvu.ssm.dao.RoleDao;
import cn.jx.jjvu.ssm.dao.RolePerDao;
import cn.jx.jjvu.ssm.domain.entity.Role_Per;
import cn.jx.jjvu.ssm.domain.entity.Sys_Per;
import cn.jx.jjvu.ssm.domain.entity.Sys_Role;
import cn.jx.jjvu.ssm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("roleService")
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private PerDao perDao;

    @Autowired
    private RolePerDao rolePerDao;


    public List<Sys_Role> findAllRole() {

        return roleDao.findAllRole();
    }

    @Override
    public void addRole(Sys_Role role) {

        roleDao.addRole(role);
    }

    @Override
    public void delRole(Integer id) {
        roleDao.delRole(id);
        rolePerDao.delRidAndPid(id);
    }


    @Override
    public List<Sys_Per> toEditRolePer(Integer roleId) {
        List<Role_Per> role_pers = rolePerDao.findRidAndPid(roleId);
        List<Sys_Per> sysPerList = perDao.findAllPer();

        List<Sys_Per> sysPers = new ArrayList<>();


        for (Role_Per role_per : role_pers) {
            Integer pid = role_per.getPid();
            for (Sys_Per sysPer : sysPerList) {
                if (pid != null && sysPer.getParentid() == 0) {
                    sysPer.setChecked("1");
                }
                Integer per_id = sysPer.getPer_id();
                if (per_id.equals(pid)) {
                    sysPer.setChecked("1");
                }

            }

        }
        sysPers.addAll(sysPerList);
        return sysPers;

    }

    @Override
    public void editRolePer(Integer roleId, Integer[] perId) {

        rolePerDao.delRidAndPid(roleId);

        Role_Per role_per = new Role_Per();

        for (Integer pid : perId) {
            role_per.setRid(roleId);
            role_per.setPid(pid);
            rolePerDao.addId(role_per);
        }


    }


}
