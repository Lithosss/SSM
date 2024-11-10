package cn.jx.jjvu.ssm.dao;

import cn.jx.jjvu.ssm.domain.entity.Sys_Role;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface RoleDao {

    @Select("select * from sys_role r " +
            "left join sys_user_role ur on ur.rid=r.role_id " +
            "left join sys_user u on u.id=ur.uid " +
            "where u.id=#{uid}")
        //根据账号的ID值查找到角色信息
    List<Sys_Role> findRolesByUId(int uid);

    @Select("select * from sys_role")
    List<Sys_Role> findAllRole();

    @Update("insert into sys_role(role_name,role_desc) values (#{role_name},#{role_desc})")
    void addRole(Sys_Role role);

    @Delete("delete from sys_role where role_id=#{id}")
    void delRole(Integer id);

}
