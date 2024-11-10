package cn.jx.jjvu.ssm.domain.entity;

public class Sys_Role {
    private int role_id;
    private String role_name;
    private String role_desc;

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public String getRole_desc() {
        return role_desc;
    }

    public void setRole_desc(String role_desc) {
        this.role_desc = role_desc;
    }

    @Override
    public String toString() {
        return "Sys_Role{" +
                "role_id=" + role_id +
                ", role_name='" + role_name + '\'' +
                ", role_desc='" + role_desc + '\'' +
                '}';
    }
}
