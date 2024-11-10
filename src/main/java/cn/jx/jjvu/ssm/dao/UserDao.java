package cn.jx.jjvu.ssm.dao;

import cn.jx.jjvu.ssm.domain.entity.Sys_User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserDao {

    @Select("select * from sys_user where username=#{username}")
    Sys_User findUserByUsername(String username);

    @Insert("insert into sys_user(username,password) values(#{username},#{password})")
    void addUser(Sys_User user);

    @Select("select * from sys_user")
    List<Sys_User> findAllUser();

    @Delete("delete from sys_user where id=#{id}")
    void delUserById(Integer userId);


    @Select("select * from sys_user where id=#{id}")
    Sys_User findUserById(Integer userId);

    @Update("update sys_user set username=#{username},password=#{password} where id=#{id}")
    void editUser(Sys_User user);


    @Select("select * from sys_user where username=#{username} and id<>#{id}")
    Sys_User findUserByUsernameAndId(Sys_User user);


}

