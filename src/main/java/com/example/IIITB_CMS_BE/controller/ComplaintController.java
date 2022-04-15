package com.example.IIITB_CMS_BE.controller;

import com.example.IIITB_CMS_BE.beans.ComplaintDetails;
import com.example.IIITB_CMS_BE.beans.ComplaintRequest;
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

    @PostMapping("/student/addComplaint")
    public ComplaintDetails AddComplaint(@RequestBody ComplaintRequest complaintRequest){
        return complaintService.AddComplaint_Service(complaintRequest);
    }

    @GetMapping("/student/viewComplaints/{RollNo}")
    public List<ComplaintDetails> ViewComplaints(@PathVariable String RollNo){
        return complaintService.ViewComplaints_Service(RollNo);
    }
}
