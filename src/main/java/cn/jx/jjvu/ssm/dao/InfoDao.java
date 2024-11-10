package cn.jx.jjvu.ssm.dao;


import cn.jx.jjvu.ssm.domain.entity.Sys_Info;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface InfoDao {

    @Insert("insert into sys_info(id,title,author,addtime,hits,content,parent_id,menu_id) values(#{id},#{title},#{author},#{addtime},#{hits},#{content},#{parent_id},#{menu_id})")
    void addInfo(Sys_Info info);

    @Select("select * from sys_info")
    List<Sys_Info> findAllInfo();

    @Delete("delete from sys_info where id=#{id}")
    void delInfoById(Integer id);

    @Select("select * from sys_info where id=#{id}")
    Sys_Info findInfoById(Integer intId);

    @Update("update sys_info set title=#{title},author=#{author},addtime=#{addtime},hits=#{hits},content=#{content},parent_id=#{parent_id},menu_id=#{menu_id} where id=#{id}")
    void editInfo(Sys_Info info);

    @Select("select * from sys_info where parent_id=#{id}")
    List<Sys_Info> findAllInfoByParentId(Integer id);

    @Select("select * from sys_info where menu_id=#{menu_id}")
    List<Sys_Info> findAllInfoByMenuId(Integer id);

    @Select("select * from sys_info where parent_id=1 order by addtime desc limit 0,5")
    List<Sys_Info> findSpan1info();

    @Select("select * from sys_info where menu_id=24 order by addtime desc limit 0,5")
    List<Sys_Info> findSpan2info();

    @Select("select * from sys_info where menu_id=9 order by addtime desc limit 0,5")
    List<Sys_Info> findSpan3info();

    @Select("select * from sys_info where menu_id=22 order by addtime desc limit 0,5")
    List<Sys_Info> findSpan4info();
}
