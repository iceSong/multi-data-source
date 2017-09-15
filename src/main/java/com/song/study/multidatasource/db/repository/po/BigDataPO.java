package com.song.study.multidatasource.db.repository.po;

/**
 * @author Cyrus
 * @version v1.0, 2017-09-15 16:58
 */
public class BigDataPO {

    private Long id;

    private Integer age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "BigDataPO{" +
                "id=" + id +
                ", age=" + age +
                '}';
    }
}
