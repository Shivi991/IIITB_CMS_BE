package com.example.IIITB_CMS_BE.controller;

import com.example.IIITB_CMS_BE.beans.ComplaintDetails;
import com.example.IIITB_CMS_BE.beans.ComplaintRequest;
import com.example.IIITB_CMS_BE.beans.Student_CompType;
import com.example.IIITB_CMS_BE.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.HttpSessionRequiredException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ComplaintController {

    @Autowired
    private ComplaintService complaintService;


    @PostMapping("/student/addComplaintRequest")
    public ComplaintDetails AddComplaintRequest(@RequestBody ComplaintRequest complaintRequest){
        return complaintService.AddComplaintRequest_Service(complaintRequest);
    }

    @PostMapping("/student/addComplaint")
    public ComplaintDetails AddComplaint(@RequestBody ComplaintDetails complaintDetails){
        return complaintService.AddComplaint_Service(complaintDetails);
    }
    @GetMapping("/student/viewComplaints/{RollNo}")
    public List<ComplaintDetails> ViewComplaints(@PathVariable String RollNo){
        return complaintService.ViewComplaints_Service(RollNo);
    }

    @GetMapping("/role_complaints/{role}")
    public List<ComplaintDetails> Complaints_Role(@PathVariable String role){
        return complaintService.Complaints_Role_Service(role);
    }

    @GetMapping("/student/role_complaints/{student_compType}")
    public List<ComplaintDetails> StudentCompType(@RequestBody Student_CompType student_compType){
        return complaintService.StudentCompType_Service(student_compType);
    }

    @PostMapping("/updateComp")
    public ComplaintDetails updateComplaint(@RequestBody ComplaintDetails complaintDetails){
        return complaintService.updateComp_Service(complaintDetails);
    }
}