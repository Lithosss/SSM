package cn.jx.jjvu.ssm.service.impl;

import cn.jx.jjvu.ssm.dao.PerDao;
import cn.jx.jjvu.ssm.dao.RoleDao;
import cn.jx.jjvu.ssm.dao.UserDao;
import cn.jx.jjvu.ssm.domain.entity.Sys_Per;
import cn.jx.jjvu.ssm.domain.entity.Sys_Role;
import cn.jx.jjvu.ssm.domain.entity.Sys_User;
import cn.jx.jjvu.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private PerDao perDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Sys_User sys_user = userDao.findUserByUsername(username);

        if (sys_user == null) {
            throw new RuntimeException("账号或密码错误");
        }
        List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
        //将角色信息封装到authorities
        List<Sys_Role> roles = roleDao.findRolesByUId(sys_user.getId());
        System.out.println(roles);
        for (Sys_Role sys_role : roles) {
            authorities.add(new SimpleGrantedAuthority(sys_role.getRole_name()));
        }
        //将菜单信息封装到authorities
        List<Sys_Per> pers = perDao.findPerByUid(sys_user.getId());
        for (Sys_Per sys_per : pers) {
            authorities.add(new SimpleGrantedAuthority(sys_per.getPer_url()));
        }

        User user = new User(sys_user.getUsername(),
                sys_user.getPassword(),
                sys_user.getStatus().equals("1"),
                true,
                true,
                true,
                authorities);
        return user;

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
