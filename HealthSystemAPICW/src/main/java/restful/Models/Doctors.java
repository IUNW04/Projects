/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restful.Models;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
    @JsonInclude(JsonInclude.Include.NON_NULL)
public class Doctors extends Persons {
    private String specialization;
    private List<Patients> patients;

    public Doctors(int id, String name, String contactInformation, String address, String specialization, List<Patients> patients) {
        this.setId(id);
        this.setName(name);
        this.setContactInformation(contactInformation);
        this.setAddress(address);
        this.specialization = specialization;
        this.patients = patients;
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
