package com.example.IIITB_CMS_BE.repository;

import com.example.IIITB_CMS_BE.beans.ComplaintDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComplaintRepo extends JpaRepository<ComplaintDetails,Integer> {

    @Query(
            value = "SELECT * FROM complaint_details c WHERE c.student_roll_no=?1",
            nativeQuery = true
    )
    public List<ComplaintDetails> findStudentComplaints(String RollNo);
}
