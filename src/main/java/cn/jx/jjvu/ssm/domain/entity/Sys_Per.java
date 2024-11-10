package cn.jx.jjvu.ssm.domain.entity;


public class Sys_Per {
    private Integer per_id;
    private String per_name;
    private String per_url;
    private String permes;
    private Integer parentid;
    private String checked;

    public Integer getPer_id() {
        return per_id;
    }

    public void setPer_id(Integer per_id) {
        this.per_id = per_id;
    }

    public String getPer_name() {
        return per_name;
    }

    public void setPer_name(String per_name) {
        this.per_name = per_name;
    }

    public String getPer_url() {
        return per_url;
    }

    public void setPer_url(String per_url) {
        this.per_url = per_url;
    }

    public String getPermes() {
        return permes;
    }

    public void setPermes(String permes) {
        this.permes = permes;
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    public String getChecked() {
        return checked;
    }

    public void setChecked(String checked) {
        this.checked = checked;
    }

    @Override
    public String toString() {
        return "Sys_Per{" +
                "per_id=" + per_id +
                ", per_name='" + per_name + '\'' +
                ", per_url='" + per_url + '\'' +
                ", permes='" + permes + '\'' +
                ", parentid=" + parentid +
                ", checked='" + checked + '\'' +
                '}';
    }
}
