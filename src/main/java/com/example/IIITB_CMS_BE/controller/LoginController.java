package com.example.IIITB_CMS_BE.controller;


import com.example.IIITB_CMS_BE.beans.EmpDetails;
import com.example.IIITB_CMS_BE.beans.LoginRequest;
import com.example.IIITB_CMS_BE.beans.StudentDetails;
import com.example.IIITB_CMS_BE.beans.StudentLoginRequest;
import com.example.IIITB_CMS_BE.service.LoginService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class LoginController {
    private static final Logger logger = LogManager.getLogger(LoginController.class);
    @Autowired
    private LoginService loginService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/signup")//other than student
    public EmpDetails SignUp(@RequestBody EmpDetails empDetails){
        logger.info("[" + HttpStatus.OK + "]");
        return loginService.SignUp_Service(empDetails);
    }

    @PostMapping("/login")
    public ResponseEntity<?> SignIn(@RequestBody LoginRequest loginRequest) throws Exception{
        logger.info("[" + HttpStatus.OK + "]");
        return ResponseEntity.ok(loginService.SignIn_Service(loginRequest));
    }

    @PostMapping("/student/signup")
    public StudentDetails StudentSignUp(@RequestBody StudentDetails studentDetails){
        logger.info("[" + HttpStatus.OK + "]");
        return loginService.StudentSignUp_service(studentDetails);
    }

    @PostMapping("/student/login")
    public ResponseEntity<?> StudentSignIn(@RequestBody StudentLoginRequest studentLoginRequest) throws Exception{
        logger.info("[" + HttpStatus.OK + "]");
        return ResponseEntity.ok(loginService.StudentSignIn_Service(studentLoginRequest));
    }
}
