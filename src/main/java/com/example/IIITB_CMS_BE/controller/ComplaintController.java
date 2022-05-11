package com.example.IIITB_CMS_BE.controller;

import com.example.IIITB_CMS_BE.beans.ComplaintDetails;
import com.example.IIITB_CMS_BE.beans.ComplaintRequest;
import com.example.IIITB_CMS_BE.beans.Student_CompType;
import com.example.IIITB_CMS_BE.service.ComplaintService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpSessionRequiredException;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ComplaintController {
    private static final Logger logger = LogManager.getLogger(ComplaintController.class);

    @Autowired
    private ComplaintService complaintService;


    @PostMapping("/student/addComplaintRequest")
    public ComplaintDetails AddComplaintRequest(@RequestBody ComplaintRequest complaintRequest){
        logger.info("[" + HttpStatus.OK + "]");
        return complaintService.AddComplaintRequest_Service(complaintRequest);
    }

    @PostMapping("/student/addComplaint")
    public ComplaintDetails AddComplaint(@RequestBody ComplaintDetails complaintDetails){
        logger.info("[" + HttpStatus.OK + "]");
        return complaintService.AddComplaint_Service(complaintDetails);
    }
    @GetMapping("/student/viewComplaints/{RollNo}")
    public List<ComplaintDetails> ViewComplaints(@PathVariable String RollNo){
        List<ComplaintDetails> res= complaintService.ViewComplaints_Service(RollNo);
        if(res==null)
            logger.info("[" + HttpStatus.NOT_FOUND + "]");
        else
            logger.info("[" + HttpStatus.OK + "]");
        return res;
    }

    @GetMapping("/role_complaints/{role}")
    public List<ComplaintDetails> Complaints_Role(@PathVariable String role){
        List<ComplaintDetails> res= complaintService.Complaints_Role_Service(role);
        if(res==null)
            logger.info("[" + HttpStatus.NOT_FOUND + "]");
        else
            logger.info("[" + HttpStatus.OK + "]");
        return res;
    }

    @GetMapping("/student/role_complaints/{student_compType}")
    public List<ComplaintDetails> StudentCompType(@RequestBody Student_CompType student_compType){
        List<ComplaintDetails> res= complaintService.StudentCompType_Service(student_compType);
        if(res==null)
            logger.info("[" + HttpStatus.NOT_FOUND + "]");
        else
            logger.info("[" + HttpStatus.OK + "]");
        return res;
    }

    @PostMapping("/updateComp")
    public ComplaintDetails updateComplaint(@RequestBody ComplaintDetails complaintDetails){
        logger.info("[" + HttpStatus.OK + "]");
        return complaintService.updateComp_Service(complaintDetails);
    }
}