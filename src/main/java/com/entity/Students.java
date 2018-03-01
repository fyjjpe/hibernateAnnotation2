package com.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by yuanjie.fang on 2018/3/1.
 * 学生实体类
 */
@Entity()
@Table(name = "t_students")
public class Students implements Serializable {

    private static final long serialVersionUID = -8019929135094013110L;

//    @Id
////    @GeneratedValue(strategy = GenerationType.AUTO)
//    @GeneratedValue(generator = "sid")
//    @GenericGenerator(name = "sid",strategy = "assigned")
//    @Column(length = 8)
////    private int sid;//学号
//    private String sid;


    //使用嵌入式主键类
    @EmbeddedId
    private StudentsPK pk;


//    @Id
//    @Column(length = 8)
    private String sname;//姓名
    private String gender;//性别
    private Date birthday;//出生日期
    private String major;//专业
//    private String address;//地址
    //定义对象类型属性
    private Address add;

    @Transient/*表示该属性不会被ORM映射到表里的字段*/
    private double salary;//学生薪水

    public Students() {
    }

    public Students(StudentsPK pk, String sname, String gender, Date birthday, String major, Address add) {
        this.pk = pk;
        this.sname = sname;
        this.gender = gender;
        this.birthday = birthday;
        this.major = major;
        this.add = add;
    }

//    @Id


//    public String getSid() {
//        return sid;
//    }
//
//    public void setSid(String sid) {
//        this.sid = sid;
//    }


    public StudentsPK getPk() {
        return pk;
    }

    public void setPk(StudentsPK pk) {
        this.pk = pk;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Embedded
    public Address getAdd() {
        return add;
    }

    public void setAdd(Address add) {
        this.add = add;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}

