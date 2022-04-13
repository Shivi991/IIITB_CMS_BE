package com.example.IIITB_CMS_BE.controller;

import com.example.IIITB_CMS_BE.beans.StudentDetails;
import com.example.IIITB_CMS_BE.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping("/addStudent")
    public StudentDetails AddStudent(@Valid @RequestBody StudentDetails studentDetails){
        return adminService.AddStudent_Service(studentDetails);
    }

    @GetMapping("/viewStudents")
    public List<StudentDetails> ViewStudents(){
        return adminService.ViewStudent_Service();
    }
//    @PutMapping("/updateAccept")
//    public patientDetails updateAccept(@RequestBody patientDetails pd){
//        return pdS.updateAcceptRest(pd);
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<HttpStatus> deletePatientDetails(@PathVariable String id){
//        try{
//            this.pdS.deletePatientDetailsRest(Integer.valueOf(id));
//            return new ResponseEntity<>(HttpStatus.OK);
//        }catch (Exception e){
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

    @PutMapping("/updateStudent")
    public StudentDetails UpdateStudent(@RequestBody StudentDetails studentDetails){
        return adminService.UpdateStudent_Service(studentDetails);
    }


    @DeleteMapping("/deleteStudent/{roll_no}")
    public ResponseEntity<HttpStatus> DeleteStudent(@PathVariable String roll_no){
        try {
            this.adminService.DeleteStudent_Service(roll_no);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
