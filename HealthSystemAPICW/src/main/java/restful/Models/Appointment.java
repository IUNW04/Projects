/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restful.Models;

import java.util.List;

/**
 *
 * @author imadhuddin
 */
public class Appointment {
    private int apId;
    private String date;
    private String time;
    private String reason;
    private String duration;
    private String location;
    
    private List<Patients> patients;
    private List<Doctors> doctors;
    
   public  Appointment() {
       
   }

    public Appointment(int apId, String date, String time, String reason, String duration, String location, List<Patients> patients, List<Doctors> doctors) {
        this.apId=apId;
        this.date = date;
        this.time = time;
        this.reason = reason;
        this.duration = duration;
        this.location = location;
        this.patients = patients;
        this.doctors = doctors;
    }
    
        public int getApId() {
        return apId;
    }

    public void setApId(int apId) {
        this.apId = apId;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Patients> getPatients() {
        return patients;
    }

    public void setPatients(List<Patients> patients) {
        this.patients = patients;
    }

    public List<Doctors> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctors> doctors) {
        this.doctors = doctors;
    }



 
   
    
}
