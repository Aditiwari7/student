package com.CollegeStudent.student;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private EnggBranch branchName;
    private String HodName;
    private String contactNo;
    private int seats;

    @OneToMany(mappedBy = "stuBranch", cascade = CascadeType.ALL)
    private List<Student> students;

    public Branch(){}

    public Branch(EnggBranch branch, String hodName, String contact, int seat){
        this.branchName = branch;
        this.HodName = hodName;
        this.contactNo = contact;
        this.seats = seat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public EnggBranch getBranchName() {
        return branchName;
    }

    public void setBranchName(EnggBranch branchName) {
        this.branchName = branchName;
    }

    public String getHodName() {
        return HodName;
    }

    public void setHodName(String hodName) {
        HodName = hodName;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }
}
