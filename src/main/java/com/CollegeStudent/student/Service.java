package com.CollegeStudent.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
    branchRepository branchRepository1;

    @Autowired
    studentRepository studentRepository1;

    private EnggBranch latestBranch;
    private int currYear;

    public void addStudent(Student student){
        latestBranch = student.getBranch();
        currYear = student.getYearOfAdmission();
        studentRepository1.save(student);
    }

    public void addBranch(Branch branch){
        branchRepository1.save(branch);
    }

    public List<String> contactsOfHOD(){
        List<String> contacts = new ArrayList<>();

        List<Branch> Hods = branchRepository1.findAll();
        EnggBranch curr = maxPassingInBranch();

        for (Branch branch : Hods){
            if(curr == branch.getBranchName()){
                contacts.add(branch.getContactNo());
            }
        }

        return contacts;
    }

    public EnggBranch maxPassingInBranch(){
        int totalStudent = 0;
        int passingStudent = 0;
        Float max = Float.MIN_VALUE;
        EnggBranch currBranch = null;

        List<Branch> Hods = branchRepository1.findAll();
        List<Student> students = studentRepository1.findAll();

        for (Branch branch : Hods){
            for(Student stu : students){
                totalStudent++;
                passingStudent++;
            }
            if(passingStudent/totalStudent > max){
                max = Float.valueOf((passingStudent/totalStudent));
                currBranch = branch.getBranchName();
            }
        }
        return currBranch;
    }

    public List<String> rollNoList(){
        List<String> rollList = new ArrayList<>();

        List<Student> students = studentRepository1.findAll();
        for(Student student : students){
            if(student.getBranch()==latestBranch && student.getYearOfAdmission()==currYear){
                rollList.add(student.getRollNo());
            }
        }

        return rollList;
    }


    public int grant(){
        int seats = 0;

        List<Branch> department = branchRepository1.findAll();
        EnggBranch curr = maxPassingInBranch();

        for (Branch currDepartment : department){
            if(currDepartment.getBranchName() == curr){
                seats = currDepartment.getSeats();
            }
        }

        return seats;
    }

}
