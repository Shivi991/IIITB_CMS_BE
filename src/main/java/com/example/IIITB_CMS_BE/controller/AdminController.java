package com.example.IIITB_CMS_BE.controller;

import com.example.IIITB_CMS_BE.beans.ComplaintDetails;
import com.example.IIITB_CMS_BE.beans.EmpDetails;
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
    public StudentDetails AddStudent( @RequestBody StudentDetails studentDetails){
        return adminService.AddStudent_Service(studentDetails);
    }

    @GetMapping("/getStudent/{RollNo}")
    public StudentDetails GetStudent(@PathVariable String RollNo){
        return adminService.GetStudent_Service(RollNo);
    }

    @GetMapping("/viewStudents")
    public List<StudentDetails> ViewStudents(){
        return adminService.ViewStudent_Service();
    }

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

    @GetMapping("/getUser/{email}")
    public EmpDetails GetUser(@PathVariable String email){
        return adminService.GetEmployee_Service(email);
    }

    @PostMapping("/addUser")
    public EmpDetails AddUser( @RequestBody EmpDetails empDetails){
        return adminService.AddEmp_Service(empDetails);
    }

    @GetMapping("/viewUsers")
    public List<EmpDetails> ViewUsers(){
        return adminService.ViewEmp_Service();
    }

    @PutMapping("/updateUser")
    public EmpDetails UpdateUser(@RequestBody EmpDetails empDetails){
        return adminService.UpdateEmp_Service(empDetails);
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<HttpStatus> DeleteUser(@PathVariable String id){
        try {
            this.adminService.DeleteEmp_Service(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/viewComplaints")
    public List<ComplaintDetails> ViewComplaints(){
        return adminService.ViewComplaints_Service();
    }

    @GetMapping("/getComplaint/{compID}")
    public  ComplaintDetails GetComplaint(@PathVariable Integer compID){
        return adminService.GetComplaint_Service(compID);
    }
    @PostMapping("/updateComplaint")
    public ComplaintDetails UpdateComplaint(@RequestBody ComplaintDetails complaintDetails){
        System.out.println(complaintDetails);
        return adminService.UpdateComplaint_Service(complaintDetails);
    }
}
