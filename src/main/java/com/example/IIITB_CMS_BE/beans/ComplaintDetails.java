package com.example.IIITB_CMS_BE.beans;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;

@Entity
@Table()
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ComplaintDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    //private String rollNo;


    private String ComplaintType;

    private String Description;

    private String Status;//Pending Accepted Rejected Solved

    private String Response;


    private String TimeStamp;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="Student_RollNo")
    private StudentDetails studentDetails;

    @Override
    public String toString() {
        return "ComplaintDetails{" +
                "id=" + id +
                ", ComplaintType='" + ComplaintType + '\'' +
                ", Description='" + Description + '\'' +
                ", Status='" + Status + '\'' +
                ", Response='" + Response + '\''+
                ", TimeStamp='" + TimeStamp + '\'' +
                ", studentDetails=" + studentDetails +
                '}';
    }
}
