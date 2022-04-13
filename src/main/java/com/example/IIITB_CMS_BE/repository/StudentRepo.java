package com.example.IIITB_CMS_BE.repository;

import com.example.IIITB_CMS_BE.beans.StudentDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<StudentDetails,String> {

    @Query(
            value = "SELECT * FROM student_details s WHERE s.roll_no = ?1",
            nativeQuery = true)
    public StudentDetails findByRollNo(String RollNo);
}
