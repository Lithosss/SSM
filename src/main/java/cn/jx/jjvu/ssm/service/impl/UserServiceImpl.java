package cn.jx.jjvu.ssm.service.impl;

import cn.jx.jjvu.ssm.dao.PerDao;
import cn.jx.jjvu.ssm.dao.RoleDao;
import cn.jx.jjvu.ssm.dao.UserDao;
import cn.jx.jjvu.ssm.domain.LoginUser;
import cn.jx.jjvu.ssm.domain.VO.AuthUserVO;
import cn.jx.jjvu.ssm.domain.entity.Sys_User;
import cn.jx.jjvu.ssm.service.UserService;
import cn.jx.jjvu.ssm.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private PerDao perDao;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public AuthUserVO login(Sys_User sysUser) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(sysUser.getUsername(), sysUser.getPassword());
        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        if(Objects.isNull(authentication)) {
            throw new RuntimeException("登录失败");
        }

        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        String jwt = JwtUtils.createJWT(loginUser,null);
        AuthUserVO authUserVO = new AuthUserVO();
        authUserVO.setUser(loginUser);
        authUserVO.setToken(jwt);
        return authUserVO;

    }




    public Map addUser(Sys_User user) {


        Sys_User user1 = userDao.findUserByUsername(user.getUsername());
        Map map = new HashMap();
        if (user1 != null) {
            map.put("usernamemsg", "账号被使用");
        } else {
            map = null;
            userDao.addUser(user);
        }
        return map;

    }


    public List findAllUser() {
        return userDao.findAllUser();
    }

    public void delUserById(Integer id) {
        userDao.delUserById(id);
    }


    public Sys_User findUserById(Integer id) {
        return userDao.findUserById(id);
    }


    public Map editUser(Sys_User user) {

        Sys_User user1 = userDao.findUserByUsernameAndId(user);
        Map map = new HashMap();
        if (user1 != null) {
            map.put("usernamemsg", "账号被使用");
        } else {
            map = null;
            userDao.editUser(user);
        }
        return map;
    }




}
