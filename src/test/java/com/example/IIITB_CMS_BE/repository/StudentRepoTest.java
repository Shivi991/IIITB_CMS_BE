package com.example.IIITB_CMS_BE.repository;

import com.example.IIITB_CMS_BE.beans.StudentDetails;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class StudentRepoTest {
    @Autowired
    private StudentRepo studentRepo;

    @Test
    public void findByRollNo(){
        StudentDetails studentDetails=new StudentDetails("MT","Keerthi","MT2021024","keerthi123@gmail.com","MTech",217,"Lilavathi",true);
        studentRepo.save(studentDetails);

        StudentDetails res=studentRepo.findByRollNo("MT");
        assertThat(res.getRollNo()).isEqualTo(studentDetails.getRollNo());
        studentRepo.deleteById(res.getRollNo());
    }

//    @Test
//    void findStudents_Active(){
//        StudentDetails studentDetails=new StudentDetails("MT2021024","Keerthi","MT2021024","keerthi@gmail.com","MTech",217,"Lilavathi",true);
//        studentRepo.save(studentDetails);
//        List<StudentDetails> res=studentRepo.findStudents_Active();
//        assertThat(res.getRollNo()).isEqualTo(studentDetails.getRollNo());
//        studentRepo.deleteById(res.getRollNo());
//
//    }

}