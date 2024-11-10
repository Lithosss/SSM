package cn.jx.jjvu.ssm.domain.entity;

public class Sys_Info {
    private Integer id;
    private String title;
    private String author;
    private String addtime;
    private Integer hits;
    private String content;
    private Integer parent_id;
    private Integer menu_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAddtime() {
        return addtime;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime;
    }

    public Integer getHits() {
        return hits;
    }

    public void setHits(Integer hits) {
        this.hits = hits;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getParent_id() {
        return parent_id;
    }

    public void setParent_id(Integer parent_id) {
        this.parent_id = parent_id;
    }

    public Integer getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(Integer menu_id) {
        this.menu_id = menu_id;
    }

    @Override
    public String toString() {
        return "Sys_Info{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", addtime='" + addtime + '\'' +
                ", hits=" + hits +
                ", content='" + content + '\'' +
                ", parent_id=" + parent_id +
                ", menu_id=" + menu_id +
                '}';
    }
}
