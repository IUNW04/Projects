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
public class Doctors extends Persons {
    private String specialization;
    private List<Patients> patients;
    private String languages;
    private String experience;

    public Doctors() {
    }

    public Doctors(int id, String name, String contactInformation, String address, String specialization) {
        super(id, name, contactInformation, address);
        this.specialization = specialization;
    }
    
    
    public Doctors(int id, String name,String age,String gender, String contactInformation , String address, String specialization, String languages, String experience) {
        super(id, name, age, gender, contactInformation, address);
        this.specialization = specialization;
        this.languages = languages;
        this.experience = experience;
    }
    
        public Doctors(int id, String name, String contactInformation ,  String specialization, String languages, String experience) {
        super(id, name, contactInformation);
        this.specialization = specialization;
        this.languages = languages;
        this.experience = experience;
    }
    
    
@JsonInclude(JsonInclude.Include.NON_NULL)
    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
@JsonInclude(JsonInclude.Include.NON_NULL)
    public List<Patients> getPatients() {
        return patients;
    }

    public void setPatients(List<Patients> patients) {
        this.patients = patients;
    }
}