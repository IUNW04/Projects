package restful.Models;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.List;
//so that "null" isnt shown in json output when i simplify patirnt details for doctor and vice versa
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "name", "age", "gender", "contactInformation", "address", "specialization", "languages", "experience", "patients" })
//Having to set he order manually because for some reason specialization and languages come after the doctors patients in the json output
public class Doctors extends Persons {
    private String specialization;
    private String languages;
    private String experience;
    private List<Patients> patients;


    public Doctors() {
        
    }

    

    public Doctors(int id, String name, String age,  String gender, String contactInformation, String address, String specialization, String languages, String experience, List<Patients> patients) {
        this.setId(id);
        this.setName(name);
        this.setAge(age);
        this.setContactInformation(contactInformation);
        this.setAddress(address);
        this.setGender(gender);
        this.specialization = specialization;
        this.languages = languages;
        this.experience = experience;
        this.patients = patients;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public List<Patients> getPatients() {
        return patients;
    }

    public void setPatients(List<Patients> patients) {
        this.patients = patients;
    }
}
