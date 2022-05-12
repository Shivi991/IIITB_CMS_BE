package com.example.IIITB_CMS_BE.service;

import com.example.IIITB_CMS_BE.beans.StudentDetails;
import com.example.IIITB_CMS_BE.repository.StudentRepo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class AdminServiceTest {

    @Autowired
    private AdminService adminService;

    @MockBean
    private StudentRepo studentRepo;

    @Test
    void ViewStudent_Service(){

        List<StudentDetails> res1=studentRepo.findStudents_Active();
        List<StudentDetails> res2=adminService.ViewStudent_Service();

        Assertions.assertThat(res1.size()).isEqualTo(res2.size());

    }
}
