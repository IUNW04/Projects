/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restful.Models;

/**
 *
 * @author imadhuddin
 */
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Patients extends Persons {
    private String medicalHistory;
    private String currentHealthStatus;
    private List<Doctors> doctors;

    public Patients() {
    }

    public Patients(int id, String name,String age, String gender, String contactInformation, String address, String medicalHistory, String currentHealthStatus) {
        super(id, name, contactInformation, address);
        this.medicalHistory = medicalHistory;
        this.currentHealthStatus = currentHealthStatus;
    }
    
        public Patients(int id, String name, String contactInformation, String age, String gender ) {
        super(id, name, contactInformation, age, gender);
    }
    
@JsonInclude(JsonInclude.Include.NON_NULL)
    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }
@JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCurrentHealthStatus() {
        return currentHealthStatus;
    }

    public void setCurrentHealthStatus(String currentHealthStatus) {
        this.currentHealthStatus = currentHealthStatus;
    }
@JsonInclude(JsonInclude.Include.NON_NULL)
    public List<Doctors> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctors> doctors) {
        this.doctors = doctors;
    }
}

