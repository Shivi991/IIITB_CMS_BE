package com.example.IIITB_CMS_BE.controller;

import com.example.IIITB_CMS_BE.IiitbCmsBeApplication;
import com.example.IIITB_CMS_BE.beans.ComplaintDetails;
import com.example.IIITB_CMS_BE.beans.EmpDetails;
import com.example.IIITB_CMS_BE.beans.StudentDetails;
import com.example.IIITB_CMS_BE.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    private static final Logger logger = LogManager.getLogger(AdminController.class);

    @PostMapping("/addStudent")
    public StudentDetails AddStudent( @RequestBody StudentDetails studentDetails){
        logger.info("[" + HttpStatus.OK + "]");
        return adminService.AddStudent_Service(studentDetails);
    }

    @GetMapping("/getStudent/{RollNo}")
    public StudentDetails GetStudent(@PathVariable String RollNo){
        StudentDetails sd=adminService.GetStudent_Service(RollNo);
        if(sd == null)
            logger.info("[" + HttpStatus.NOT_FOUND + "]");
        else
            logger.info("[" + HttpStatus.OK + "]");
        return sd;
    }

    @GetMapping("/viewStudents")
    public List<StudentDetails> ViewStudents(){
        List<StudentDetails> res=adminService.ViewStudent_Service();
        if(res==null)
            logger.info("[" + HttpStatus.NOT_FOUND + "]");
        else
            logger.info("[" + HttpStatus.OK + "]");
        return res;
    }

    @PutMapping("/updateStudent")
    public StudentDetails UpdateStudent(@RequestBody StudentDetails studentDetails){
        StudentDetails res= adminService.UpdateStudent_Service(studentDetails);
        if(res==null)
            logger.info("[" + HttpStatus.NOT_FOUND + "]");
        else
            logger.info("[" + HttpStatus.OK + "]");
        return res;
    }


    @DeleteMapping("/deleteStudent/{roll_no}")
    public ResponseEntity<HttpStatus> DeleteStudent(@PathVariable String roll_no){
        try {
            this.adminService.DeleteStudent_Service(roll_no);
            logger.info("[" + HttpStatus.OK + "]");
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception e){
            logger.info("[" + HttpStatus.NOT_FOUND + "]");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getUser/{email}")
    public EmpDetails GetUser(@PathVariable String email){

        EmpDetails res= adminService.GetEmployee_Service(email);
        if(res==null)
            logger.info("[" + HttpStatus.NOT_FOUND + "]");
        else
            logger.info("[" + HttpStatus.OK + "]");
        return res;
    }

    @PostMapping("/addUser")
    public EmpDetails AddUser( @RequestBody EmpDetails empDetails){
        logger.info("[" + HttpStatus.OK + "]");
        return adminService.AddEmp_Service(empDetails);
    }

    @GetMapping("/viewUsers")
    public List<EmpDetails> ViewUsers(){
        List<EmpDetails> res= adminService.ViewEmp_Service();
        if(res==null)
            logger.info("[" + HttpStatus.NOT_FOUND + "]");
        else
            logger.info("[" + HttpStatus.OK + "]");
        return res;
    }

    @PutMapping("/updateUser")
    public EmpDetails UpdateUser(@RequestBody EmpDetails empDetails){
        EmpDetails res= adminService.UpdateEmp_Service(empDetails);
        if(res==null)
            logger.info("[" + HttpStatus.NOT_FOUND + "]");
        else
            logger.info("[" + HttpStatus.OK + "]");
        return res;
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<HttpStatus> DeleteUser(@PathVariable String id){
        try {
            this.adminService.DeleteEmp_Service(id);
            logger.info("[" + HttpStatus.OK + "]");
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception e){
            logger.info("[" + HttpStatus.NOT_FOUND + "]");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/viewComplaints")
    public List<ComplaintDetails> ViewComplaints(){
        List<ComplaintDetails> res= adminService.ViewComplaints_Service();
        if(res==null)
            logger.info("[" + HttpStatus.NOT_FOUND + "]");
        else
            logger.info("[" + HttpStatus.OK + "]");
        return res;
    }

    @GetMapping("/getComplaint/{compID}")
    public  ComplaintDetails GetComplaint(@PathVariable Integer compID){
        logger.info("[" + HttpStatus.OK + "]");
        return adminService.GetComplaint_Service(compID);
    }
    @PostMapping("/updateComplaint")
    public ComplaintDetails UpdateComplaint(@RequestBody ComplaintDetails complaintDetails){
        logger.info("[" + HttpStatus.OK + "]");
        System.out.println(complaintDetails);
        return adminService.UpdateComplaint_Service(complaintDetails);
    }
}
