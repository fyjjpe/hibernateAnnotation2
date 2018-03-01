package com.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by yuanjie.fang on 2018/3/1.
 * 学生主键类
 */
@Embeddable
public class StudentsPK implements Serializable{
    private static final long serialVersionUID = -6374391452043010061L;
    @Column(length = 18)
    private String id;//学生身份证号
    @Column(length = 8)
    private String sid;//学生学号

    public StudentsPK() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentsPK that = (StudentsPK) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        return sid != null ? sid.equals(that.sid) : that.sid == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (sid != null ? sid.hashCode() : 0);
        return result;
    }
}
