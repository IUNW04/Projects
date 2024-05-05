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
        Doctors doctor1 = new Doctors(101, "Dr. Jeremy",null, "07444434668", null, null, null, "Cardiology", null);
        Doctors doctor2 = new Doctors(102, "Dr. Raami", null,"07886578902", null, null, null, "Dermatology", null);

        // Create patients and associate doctors
        patients.add(new Patients(1, "Mohammed Naahid","22", "07456785667", "123 Elm St", "Allergic to peanuts", "Stable", List.of(doctor1)));
        patients.add(new Patients(2, "Zaahir Uddin", "20","07409895691", "456 Oak St", "Asthma", "Improving", List.of(doctor2)));
        patients.add(new Patients(3, "Hannah Maddison", "30","07489701221", "789 Maple St", "Diabetes", "Stable", List.of(doctor1, doctor2)));
        patients.add(new Patients(4, "Nihan Miah","60", "07456782232", "101 Pine St", "High blood pressure", "Improving", List.of(doctor1)));
        patients.add(new Patients(5, "Ashraf Islam","70", "07456789980", "101 Pine St", "High blood pressure", "Improving", List.of(doctor2)));
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
}
