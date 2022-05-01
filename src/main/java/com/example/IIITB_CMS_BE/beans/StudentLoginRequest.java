package com.example.IIITB_CMS_BE.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentLoginRequest {
    private String studentID;
    private String password;

}
