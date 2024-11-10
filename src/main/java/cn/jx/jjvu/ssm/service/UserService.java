package cn.jx.jjvu.ssm.service;


import cn.jx.jjvu.ssm.domain.VO.AuthUserVO;
import cn.jx.jjvu.ssm.domain.entity.Sys_User;
import java.util.List;
import java.util.Map;

public interface UserService  {

    AuthUserVO login(Sys_User sysUser);

    Map addUser(Sys_User user);

    List findAllUser();

    void delUserById(Integer id);

    Sys_User findUserById(Integer id);

    Map editUser(Sys_User user);



}
