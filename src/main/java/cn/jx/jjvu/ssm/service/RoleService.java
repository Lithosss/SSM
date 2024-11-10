package cn.jx.jjvu.ssm.service;

import cn.jx.jjvu.ssm.domain.entity.Sys_Per;
import cn.jx.jjvu.ssm.domain.entity.Sys_Role;

import java.util.List;


public interface RoleService {

    List<Sys_Role> findAllRole();

    void addRole(Sys_Role role);

    void delRole(Integer id);



    List<Sys_Per> toEditRolePer(Integer roleId);

    void editRolePer(Integer roleId,Integer[] perId);
}
