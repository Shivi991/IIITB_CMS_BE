package com.example.IIITB_CMS_BE.repository;

import com.example.IIITB_CMS_BE.beans.EmpDetails;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmpRepoTest {
    @Autowired
    private EmpRepo empRepo;

    @Test
    void findByID(){
        EmpDetails empDetails=new EmpDetails("Emp100","Admin","Emp","Emp","emp100@gmail.com",true);
        empRepo.save(empDetails);

        EmpDetails res=empRepo.findByID("Emp100");
        assertThat(res.getId()).isEqualTo(empDetails.getId());
        empRepo.delete(empDetails);
    }

}