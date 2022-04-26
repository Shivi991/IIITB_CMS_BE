package com.example.IIITB_CMS_BE.service;

import com.example.IIITB_CMS_BE.beans.ComplaintDetails;
import com.example.IIITB_CMS_BE.beans.ComplaintRequest;
import com.example.IIITB_CMS_BE.beans.StudentDetails;
import com.example.IIITB_CMS_BE.beans.Student_CompType;
import com.example.IIITB_CMS_BE.repository.ComplaintRepo;
import com.example.IIITB_CMS_BE.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ComplaintService {

    @Autowired
    private ComplaintRepo complaintRepo;

    @Autowired
    private StudentRepo studentRepo;

    SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

    public ComplaintDetails AddComplaint_Service(ComplaintRequest complaintRequest){

        ComplaintDetails complaintDetails=new ComplaintDetails();

        StudentDetails studentDetails=studentRepo.getById(complaintRequest.getStudentRollNo());
        complaintDetails.setStudentDetails(studentDetails);

        complaintDetails.setDescription(complaintRequest.getCompDesc());
        complaintDetails.setComplaintType(complaintRequest.getCompType());
        complaintDetails.setStatus("Pending");
        complaintDetails.setTimeStamp(sdf.format(new Date(System.currentTimeMillis())));

        System.out.println(sdf.format(new Date(System.currentTimeMillis())));
        System.out.println(complaintDetails);
        complaintRepo.save(complaintDetails);
        return complaintDetails;
    }

    public List<ComplaintDetails> ViewComplaints_Service(String RollNo){
        return complaintRepo.findStudentComplaints(RollNo);
    }

    public List<ComplaintDetails> Complaints_Role_Service(String role){
        return complaintRepo.Complaints_Role_Repo(role);
    }

    public List<ComplaintDetails> StudentCompType_Service(Student_CompType student_compType){
        return complaintRepo.StudentCompType_Repo(student_compType);
    }
}
