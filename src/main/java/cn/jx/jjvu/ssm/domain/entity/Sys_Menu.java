package cn.jx.jjvu.ssm.domain.entity;

import java.util.List;

public class Sys_Menu {
    private int id;
    private String name;
    private int parent_id;
    private List<Sys_Menu> children;

    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getParent_id() {
        return parent_id;
    }

    public void setParent_id(int parent_id) {
        this.parent_id = parent_id;
    }

    public List<Sys_Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Sys_Menu> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Meau{" + "id=" + id + ", name='" + name + '\'' + ", parent_id=" + parent_id + ", children=" + children + '}';
    }
}
