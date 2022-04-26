package com.example.IIITB_CMS_BE.repository;

import com.example.IIITB_CMS_BE.beans.EmpDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpRepo extends JpaRepository<EmpDetails,Integer> {
    @Query(
            value = "SELECT * FROM emp_details e WHERE e.id= ?1",
            nativeQuery = true
    )
    public EmpDetails findByID(String id);

    @Query(
            value = "SELECT * FROM emp_details e WHERE e.name= ?1",
            nativeQuery = true)
    public EmpDetails findByName(String name);

    @Query(
            value = "SELECT * FROM emp_details e WHERE e.status=true",
            nativeQuery = true
    )
    public List<EmpDetails> findEmp_Active();

    @Query(
            value = "SELECT * FROM emp_details e WHERE e.email= ?1",
            nativeQuery = true)
    public EmpDetails findByEmail(String email);

//    @Query(
//            value = "UPDATE emp_details e SET e.status=true WHERE e.id= ?1",
//            nativeQuery = true
//    )
//    public void DeleteEmp_InActive(String id);
}
