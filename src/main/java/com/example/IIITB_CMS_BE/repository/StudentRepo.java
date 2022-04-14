package com.example.IIITB_CMS_BE.repository;

import com.example.IIITB_CMS_BE.beans.StudentDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<StudentDetails,String> {

    @Query(
            value = "SELECT * FROM student_details s WHERE s.roll_no = ?1",
            nativeQuery = true
    )
    public StudentDetails findByRollNo(String RollNo);

    @Query(
            value = "SELECT * FROM student_details s WHERE s.status=true",
            nativeQuery = true
    )
    public List<StudentDetails> findStudents_Active();



}
