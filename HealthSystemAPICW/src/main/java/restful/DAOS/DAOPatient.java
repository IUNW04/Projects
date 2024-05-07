package restful.DAOS;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.ArrayList;
import java.util.List;
import restful.Models.Doctors;
import restful.Models.Patients;

@JsonInclude(Include.NON_NULL)
public class DAOPatient {
    private static List<Patients> patients = new ArrayList<>();

    static {
        // Create doctors
        Doctors doctor1 = new Doctors(101, "Dr. Jeremy",null, null, "07444434668", null, "Cardiology", null, null, null);
        Doctors doctor2 = new Doctors(102, "Dr. Raami", null, null, "07886578902", null,"Dermatology", null,  null, null);   
        Doctors doctor3 = new Doctors(103, "Dr. Lilly", null,null, "07997571252", null,"Physiotherapy", null,  null, null);
        // Create patients and associate doctors
        patients.add(new Patients(1, "Mohammed Naahid","22","Male", "07456785667", "123 Elm St", "Allergic to peanuts", "Stable","O+", List.of(doctor1, doctor2)));
        patients.add(new Patients(2, "Zaahir Uddin", "20","Male","07409895691", "456 Oak St", "Asthma", "Improving", "O+", List.of(doctor2)));
        patients.add(new Patients(3, "Hannah Maddison", "30","Female","07489701221", "789 Maple St", "Diabetes", "Stable","A+", List.of(doctor1)));
        patients.add(new Patients(4, "Nihan Miah","60", "Male","07456782232", "101 Pine St", "High blood pressure", "Improving","AB+", List.of(doctor1)));
        patients.add(new Patients(5, "Layla Ashington","70", "Male","07456789980", "101 Pine St", "High blood pressure", "Improving","A-", List.of(doctor3, doctor1)));
    }

    public static List<Patients> getAllPatients() {
        return patients;
    }

    public static Patients getPatientById(int id) {
        for (Patients patient : patients) {
            if (patient.getId() == id) {
                return patient;
            }
        }
        return null;
    }

    public static void addPatient(Patients patient) {
        patients.add(patient);
    }

    public static void updatePatient(Patients updatedPatient) {
        for (int i = 0; i < patients.size(); i++) {
            if (patients.get(i).getId() == updatedPatient.getId()) {
                patients.set(i, updatedPatient);
                return;
            }
        }
    }

    public static void deletePatient(int id) {
        patients.removeIf(patient -> patient.getId() == id);
    }
    
        public static Patients getSimplifiedPatients(Patients patient) {
        return new Patients(
                patient.getId(),
                patient.getName(),
                null,
                null,
                patient.getContactInformation(),
                null,
                patient.getMedicalHistory(),
                patient.getCurrentHealthStatus(),
                null,
                null
        );
    }
}
