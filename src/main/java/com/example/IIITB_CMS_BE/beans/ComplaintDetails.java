package com.example.IIITB_CMS_BE.beans;


import javax.persistence.*;

@Entity
@Table()
public class ComplaintDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String ComplaintType;

    private String Description;

    private String Status;

    private String TimeStamp;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="Student_RollNo")
    private StudentDetails studentDetails;

    public ComplaintDetails() {
    }

    public ComplaintDetails(int id,  String complaintType, String description, String status, String timeStamp, StudentDetails studentDetails) {
        this.id = id;
        ComplaintType = complaintType;
        Description = description;
        Status = status;
        TimeStamp = timeStamp;
        this.studentDetails = studentDetails;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getComplaintType() {
        return ComplaintType;
    }

    public void setComplaintType(String complaintType) {
        ComplaintType = complaintType;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getTimeStamp() {
        return TimeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        TimeStamp = timeStamp;
    }

    public StudentDetails getStudentDetails() {
        return studentDetails;
    }

    public void setStudentDetails(StudentDetails studentDetails) {
        this.studentDetails = studentDetails;
    }

    @Override
    public String toString() {
        return "ComplaintDetails{" +
                "id=" + id +
                ", ComplaintType='" + ComplaintType + '\'' +
                ", Description='" + Description + '\'' +
                ", Status='" + Status + '\'' +
                ", TimeStamp='" + TimeStamp + '\'' +
                ", studentDetails=" + studentDetails +
                '}';
    }
}
