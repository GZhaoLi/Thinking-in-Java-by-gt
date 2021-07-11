package com.gui.demo.thingInJava.tests.SSMTest.JDBCTest;

import java.util.Date;

/**
 * @Classname Student
 * @Description TODO
 * @Date 2021/7/10 22:10
 * @Created by gt136
 */
public class Student {
    private String sno;
    private String sname;
    private String sgender;
    private Date sbirthday;
    private String classes;

    @Override
    public String toString() {
        return "Student{" +
                "sno='" + sno + '\'' +
                ", sname='" + sname + '\'' +
                ", sgender='" + sgender + '\'' +
                ", sbirthday=" + sbirthday +
                ", classes='" + classes + '\'' +
                '}';
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSgender() {
        return sgender;
    }

    public void setSgender(String sgender) {
        this.sgender = sgender;
    }

    public Date getSbirthday() {
        return sbirthday;
    }

    public void setSbirthday(Date sbirthday) {
        this.sbirthday = sbirthday;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public Student(String sno, String sname, String sgender, Date sbirthday, String classes) {
        this.sno = sno;
        this.sname = sname;
        this.sgender = sgender;
        this.sbirthday = sbirthday;
        this.classes = classes;
    }

    public Student() {
    }
}
