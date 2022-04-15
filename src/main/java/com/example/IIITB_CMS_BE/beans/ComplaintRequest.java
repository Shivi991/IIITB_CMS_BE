package com.example.IIITB_CMS_BE.beans;

public class ComplaintRequest {

    private String CompType;
    private String CompDesc;
    private String StudentRollNo;

    public ComplaintRequest() {
    }

    public ComplaintRequest(String compType, String compDesc,String studentRollNo) {
        CompType = compType;
        CompDesc = compDesc;
        StudentRollNo=studentRollNo;
    }

    @Override
    public String toString() {
        return "ComplaintRequest{" +
                "CompType='" + CompType + '\'' +
                ", CompDesc='" + CompDesc + '\'' +
                ", StudentRollNo='" + StudentRollNo + '\'' +
                '}';
    }

    public String getCompType() {
        return CompType;
    }

    public void setCompType(String compType) {
        CompType = compType;
    }

    public String getCompDesc() {
        return CompDesc;
    }

    public void setCompDesc(String compDesc) {
        CompDesc = compDesc;
    }

    public String getStudentRollNo() {
        return StudentRollNo;
    }

    public void setStudentRollNo(String studentRollNo) {
        StudentRollNo = studentRollNo;
    }
}
