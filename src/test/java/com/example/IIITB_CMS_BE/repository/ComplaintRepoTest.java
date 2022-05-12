package com.example.IIITB_CMS_BE.repository;

import com.example.IIITB_CMS_BE.beans.ComplaintDetails;
import com.example.IIITB_CMS_BE.beans.StudentDetails;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class ComplaintRepoTest {

    @Autowired
    private ComplaintRepo complaintRepo;

    @Autowired
    private StudentRepo studentRepo;

    @Test
    public void findStudentComplaints(){
        List<ComplaintDetails> cdL=new ArrayList<ComplaintDetails>();
        StudentDetails studentDetails=new StudentDetails("MT","Keerthi","MT2021024","keerthi123@gmail.com","MTech",217,"Lilavathi",true);
        studentRepo.save(studentDetails);
        ComplaintDetails complaintDetails=new ComplaintDetails(100,"SAC","desc","pending","responnse","29-04-2022 10:40:00",
                new StudentDetails("MT","Keerthi","MT2021024","keerthi123@gmail.com","MTech",217,"Lilavathi",true));
        cdL.add(complaintDetails);
        complaintRepo.saveAll(cdL);

        List<ComplaintDetails> res=complaintRepo.findStudentComplaints("MT");
        assertThat(res.size()).isEqualTo(cdL.size());


        complaintRepo.deleteAll(cdL);

        studentRepo.delete(studentDetails);






    }

}