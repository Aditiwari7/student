package com.CollegeStudent.student;

import jakarta.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String rollNo;

    @Enumerated(value = EnumType.STRING)
    private EnggBranch branch;
    private int marks;

    private boolean pass;
    private int yearOfAdmission;

    @ManyToOne
    @JoinColumn
    private Branch stuBranch;

    public Student() {
    }

    public Student(String name, String rollNo, EnggBranch branch, int marks, int yearOfAdmission){
        this.name = name;
        this.rollNo = rollNo;
        this.branch = branch;
        this.marks = marks;
        if(marks >= 40) this.pass = true;
        this.yearOfAdmission = yearOfAdmission;
    }

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

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public EnggBranch getBranch() {
        return branch;
    }

    public void setBranch(EnggBranch branch) {
        this.branch = branch;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public boolean isPass() {
        return pass;
    }

    public void setPass(boolean pass) {
        this.pass = pass;
    }

    public int getYearOfAdmission() {
        return yearOfAdmission;
    }

    public void setYearOfAdmission(int yearOfAdmission) {
        this.yearOfAdmission = yearOfAdmission;
    }

    public Branch getStuBranch() {
        return stuBranch;
    }

    public void setStuBranch(Branch stuBranch) {
        this.stuBranch = stuBranch;
    }
}
