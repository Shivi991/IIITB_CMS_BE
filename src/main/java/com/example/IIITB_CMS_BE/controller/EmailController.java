package com.example.IIITB_CMS_BE.controller;

import com.example.IIITB_CMS_BE.beans.EmailDetails;
import com.example.IIITB_CMS_BE.service.EmailService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins="*")
public class EmailController {
    private static final Logger logger = LogManager.getLogger(EmailController.class);
    @Autowired
    private EmailService emailService;

    //api for sending email
    @PostMapping("/sendEmail")
    public ResponseEntity<?> sendEmail(@RequestBody EmailDetails emailDetails){
        System.out.println(emailDetails);
        boolean result = this.emailService.sendEmail_Service(emailDetails.getSubject(),emailDetails.getMessage(),emailDetails.getTo());
        if(result){
            logger.info("[" + HttpStatus.OK + "]");
            return ResponseEntity.ok("Email Sent Successfully...");
        }

        else{
            logger.info("[" + HttpStatus.NOT_FOUND + "]");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Email Not Sent..");
        }

    }

}
