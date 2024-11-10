package cn.jx.jjvu.ssm.dao;

import cn.jx.jjvu.ssm.domain.entity.Sys_Menu;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;


public interface MenuDao {
    @Select("select * from sys_menu")
    List<Sys_Menu> findAllMenu();


    @Insert("insert into sys_menu(name,parent_id) values(#{name},#{parent_id})")
    void addMenu(Sys_Menu menu);

    @Delete("delete from sys_menu where id=#{id}")
    void delMenuById(Integer id);


    @Select("select * from sys_menu where id=#{id}")
    Sys_Menu findMenuById(Integer id);

    @Update("update sys_menu set name=#{name} where id=#{id} and parent_id=#{parent_id}")
    void editMenu(Sys_Menu menu);

    @Select("select * from sys_menu where parent_id=#{id}")
    List<Sys_Menu> findAllDownMenu(Integer id);

    @Select("select * from sys_menu where parent_id=#{parent_id} and id=#{id}")
    Sys_Menu findDownMenuById(Sys_Menu menu);
}
