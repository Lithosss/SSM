package cn.jx.jjvu.ssm.dao;

import cn.jx.jjvu.ssm.domain.entity.Sys_Per;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface PerDao {

    @Select("select * from sys_per p " +
            "left join sys_role_per rp on p.per_id=rp.pid " +
            "left join sys_role r on r.role_id=rp.rid " +
            "left join sys_user_role ur on ur.rid=r.role_id " +
            "left join sys_user u on u.id=ur.uid " +
            "where u.id=#{uid}")
    //根据账号对应的ID值查找到菜单信息
    List<Sys_Per> findPerByUid(int uid);


    @Select("select * from sys_per")
    List<Sys_Per> findAllPer();

    @Select("select * from sys_per where parentid=#{id}")
    List<Sys_Per> findAllDownPer(Integer id);

    @Delete("delete from sys_per where per_id=#{id}")
    void delPerById(Integer id);

    @Insert("insert Sys_Per(per_name,per_url,permes,parentid) values (#{per_name},#{per_url},#{permes},#{parentid})")
    void addPer(Sys_Per per);


    @Select("select * from sys_per where per_id=#{id}")
    Sys_Per findPerById(Integer id);

    @Update("update sys_per set per_name=#{per_name},per_url=#{per_url},permes=#{permes},parentid=#{parentid} where per_id=#{per_id}")
    void updatePer(Sys_Per sysPer);

}