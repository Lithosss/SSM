package cn.jx.jjvu.ssm.domain.entity;

public class Role_Per {
    private Integer rid;
    private Integer pid;

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    @Override
    public String toString() {
        return "Role_Per{" +
                "rid=" + rid +
                ", pid=" + pid +
                '}';
    }
}
