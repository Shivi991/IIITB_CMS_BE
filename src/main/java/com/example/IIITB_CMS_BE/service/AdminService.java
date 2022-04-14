package com.example.IIITB_CMS_BE.service;


import com.example.IIITB_CMS_BE.beans.EmpDetails;
import com.example.IIITB_CMS_BE.beans.StudentDetails;
import com.example.IIITB_CMS_BE.repository.EmpRepo;
import com.example.IIITB_CMS_BE.repository.StudentRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private EmpRepo empRepo;
    //adding
    public StudentDetails AddStudent_Service(StudentDetails studentDetails){
        System.out.println(studentDetails);
        studentDetails.setStatus(true);
        studentDetails.setPassword(passwordEncoder.encode((studentDetails.getPassword())));
        studentDetails=studentRepo.save(studentDetails);
        return studentDetails;
//        if(studentRepo.findByRollNo(studentDetails.getRollNo())==null) {
//
//            return studentRepo.save(studentDetails);
//        }
//
//        return null;
    }



    public List<StudentDetails> ViewStudent_Service(){
        return studentRepo.findStudents_Active();
    }

    public StudentDetails UpdateStudent_Service(StudentDetails studentDetails){
        if(studentRepo.findByRollNo(studentDetails.getRollNo())!=null && studentDetails.isStatus()==true)
            return studentRepo.save(studentDetails);
        else
            return null;
    }

    public void DeleteStudent_Service(String roll_no){
        //StudentDetails studentDetails=studentRepo.findByRollNo(roll_no);
        StudentDetails studentDetails=studentRepo.findByRollNo(roll_no);

        if(studentDetails!=null){
            studentDetails.setStatus(false);
            studentRepo.save(studentDetails);
            //return true;
        }
        //studentRepo.DeleteStudent_InActive(roll_no);
    }


    //EMP FUNCTIONALITIES

    public EmpDetails AddEmp_Service(EmpDetails empDetails){
        empDetails.setStatus(true);
        empDetails.setPassword(passwordEncoder.encode((empDetails.getPassword())));
        empDetails=empRepo.save(empDetails);
        return empDetails;
    }

    public List<EmpDetails> ViewEmp_Service(){
        return empRepo.findEmp_Active();
    }

    public EmpDetails UpdateEmp_Service(EmpDetails empDetails){
        if(empRepo.findByID(empDetails.getId())!=null )
            return empRepo.save(empDetails);
        else
            return null;
    }

    public void DeleteEmp_Service(String id){
        //StudentDetails studentDetails=studentRepo.findByRollNo(roll_no);
        EmpDetails empDetails=empRepo.findByID(id);

        if(empDetails!=null){
            empDetails.setStatus(false);
            empRepo.save(empDetails);
            //return true;
        }
       // return false;
           // return empRepo.save(empDetails);
    }


}
