package com.example.IIITB_CMS_BE.service;


import com.example.IIITB_CMS_BE.beans.StudentDetails;
import com.example.IIITB_CMS_BE.repository.StudentRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    private StudentRepo studentRepo;

    public StudentDetails AddStudent_Service(StudentDetails studentDetails){
        if(studentRepo.findByRollNo(studentDetails.getRollNo())==null) {

            return studentRepo.save(studentDetails);
        }

        return null;
    }

    public List<StudentDetails> ViewStudent_Service(){
        return studentRepo.findAll();
    }

    public StudentDetails UpdateStudent_Service(StudentDetails studentDetails){
        if(studentRepo.findByRollNo(studentDetails.getRollNo())!=null)
            return studentRepo.save(studentDetails);
        else
            return null;
    }

    public void DeleteStudent_Service(String roll_no){
        StudentDetails studentDetails=studentRepo.findByRollNo(roll_no);
        studentRepo.delete(studentDetails);
    }
}
