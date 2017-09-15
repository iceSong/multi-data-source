package com.song.study.multidatasource.db.repository.po;

/**
 * @author Cyrus
 * @version v1.0, 2017-09-15 16:58
 */
public class BusinessPO {

    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "BusinessPO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
