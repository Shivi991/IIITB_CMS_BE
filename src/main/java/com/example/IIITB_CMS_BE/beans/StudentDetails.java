package com.example.IIITB_CMS_BE.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Entity
@Table()
public class StudentDetails {

    @Id
    private String RollNo;

    private String Name;

    private String Password;

    @Column(unique = true)
    private String MailID;

    private String Programme;

    private int RoomNo;

    private String HostelName;

    private boolean Status;


    public StudentDetails() {
    }

    public StudentDetails(String rollNo, String name, String password, String mailID, String programme, int roomNo, String hostelName,boolean status) {
        RollNo = rollNo;
        Name = name;
        Password = password;
        MailID = mailID;
        Programme = programme;
        RoomNo = roomNo;
        HostelName = hostelName;
        Status=status;
    }

    public String getRollNo() {
        return RollNo;
    }

    public void setRollNo(String rollNo) {
        RollNo = rollNo;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getMailID() {
        return MailID;
    }

    public void setMailID(String mailID) {
        MailID = mailID;
    }

    public String getProgramme() {
        return Programme;
    }

    public void setProgramme(String programme) {
        Programme = programme;
    }

    public int getRoomNo() {
        return RoomNo;
    }

    public void setRoomNo(int roomNo) {
        RoomNo = roomNo;
    }

    public String getHostelName() {
        return HostelName;
    }

    public void setHostelName(String hostelName) {
        HostelName = hostelName;
    }

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean status) {
        Status = status;
    }

    @Override
    public String toString() {
        return "StudentDetails{" +
                "RollNo='" + RollNo + '\'' +
                ", Name='" + Name + '\'' +
                ", Password='" + Password + '\'' +
                ", MailID='" + MailID + '\'' +
                ", Programme='" + Programme + '\'' +
                ", RoomNo=" + RoomNo +
                ", HostelName='" + HostelName + '\'' +
                ", Status=" + Status +
                '}';
    }
}
