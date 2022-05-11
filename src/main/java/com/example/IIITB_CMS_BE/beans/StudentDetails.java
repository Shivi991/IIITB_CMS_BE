package com.example.IIITB_CMS_BE.beans;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Entity
@Table()
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDetails {

    @Id
    private String RollNo;

    private String Name;

    private String Password;

    @Column(unique = true)
    private String Email;

    private String Programme;

    private int RoomNo;

    private String HostelName;

    private boolean Status=true ;


    @Override
    public String toString() {
        return "StudentDetails{" +
                "RollNo='" + RollNo + '\'' +
                ", Name='" + Name + '\'' +
                ", Password='" + Password + '\'' +
                ", Email='" + Email + '\'' +
                ", Programme='" + Programme + '\'' +
                ", RoomNo=" + RoomNo +
                ", HostelName='" + HostelName + '\'' +
                ", Status=" + Status +
                '}';
    }
}
