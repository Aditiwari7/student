package com.CollegeStudent.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class Controller {

    @Autowired
    Service service;

    @PostMapping("/addStudent")
    public ResponseEntity<Void> addStudent(@RequestBody Student student){
        service.addStudent(student);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/addHOD")
    public ResponseEntity<Void> addHOD(@RequestBody Branch branch){
        service.addBranch(branch);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/HODContacts")
    public List<String> HODContacts(){
        return service.contactsOfHOD();
    }

    @GetMapping("/listOfRollNo")
    public List<String> ListOfRollNo(){
        return service.rollNoList();
    }

    @GetMapping("/SeatsInBranch")
    public int SeatsInBranch(){
        return service.grant();
    }
}
