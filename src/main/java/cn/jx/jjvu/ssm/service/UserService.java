package cn.jx.jjvu.ssm.service;


import cn.jx.jjvu.ssm.domain.entity.Sys_User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Map;

public interface UserService  extends UserDetailsService {


    Map addUser(Sys_User user);

    List findAllUser();

    void delUserById(Integer id);

    Sys_User findUserById(Integer id);

    Map editUser(Sys_User user);


}
