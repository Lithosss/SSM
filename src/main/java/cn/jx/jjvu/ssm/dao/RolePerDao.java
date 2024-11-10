package cn.jx.jjvu.ssm.dao;

import cn.jx.jjvu.ssm.domain.entity.Role_Per;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RolePerDao {


    @Insert("insert into sys_role_per(rid,pid) values (#{rid},#{pid})")
    void addId(Role_Per rolePer);

    @Select("select * from sys_role_per where rid=#{roleId}")
    List<Role_Per> findRidAndPid(Integer roleId);

    @Delete("delete from sys_role_per where rid=#{id}")
    void delRidAndPid(Integer id);




}
