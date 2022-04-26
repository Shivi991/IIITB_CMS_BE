package com.example.IIITB_CMS_BE.controller;


import com.example.IIITB_CMS_BE.beans.EmpDetails;
import com.example.IIITB_CMS_BE.beans.LoginRequest;
import com.example.IIITB_CMS_BE.beans.StudentDetails;
import com.example.IIITB_CMS_BE.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/signup")//other than student
    public EmpDetails SignUp(@RequestBody EmpDetails empDetails){
        return loginService.SignUp_Service(empDetails);
    }

    @PostMapping("/login")
    public ResponseEntity<?> SignIn(@RequestBody LoginRequest loginRequest) throws Exception{
        return ResponseEntity.ok(loginService.SignIn_Service(loginRequest));
    }

    @PostMapping("/student/signup")
    public StudentDetails StudentSignUp(@RequestBody StudentDetails studentDetails){
        return loginService.StudentSignUp_service(studentDetails);
    }

    @GetMapping("/student/login")
    public ResponseEntity<?> StudentSignIn(@RequestBody LoginRequest loginRequest) throws Exception{
        return ResponseEntity.ok(loginService.SignIn_Service(loginRequest));
    }
}
