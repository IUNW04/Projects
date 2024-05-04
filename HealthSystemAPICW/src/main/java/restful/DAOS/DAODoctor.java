package restful.DAOS;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.ArrayList;
import java.util.List;
import restful.Models.Doctors;
import restful.Models.Patients;

@JsonInclude(Include.NON_NULL)
public class DAODoctor {
    private static List<Doctors> doctors = new ArrayList<>();

    static {
        Doctors doctor1 = new Doctors(101, "Dr. Jeremy", "07444434668", "783 Juniper Street NW1 8HA", "Cardiology", null);
        Doctors doctor2 = new Doctors(102, "Dr. Raami", "07886578902", "456 holden Street NW1 9BA", "Dermatology", null);

        // Associate patients with doctors
        doctor1.setPatients(getPatientsForDoctor(101));
        doctor2.setPatients(getPatientsForDoctor(102));

        doctors.add(doctor1);
        doctors.add(doctor2);
    }

        @JsonInclude(Include.NON_NULL)
    public static List<Doctors> getDoctors() {
        return doctors;
    }

        @JsonInclude(Include.NON_NULL)
    public static Doctors getDoctorById(int id) {
        for (Doctors doctor : doctors) {
            if (doctor.getId() == id) {
                return doctor;
            }
        }
        return null;
    }

    private static List<Patients> getPatientsForDoctor(int doctorId) {
        List<Patients> patientsForDoctor = new ArrayList<>();
        for (Patients patient : DAOPatient.getAllPatients()) {
            for (Doctors doctor : patient.getDoctors()) {
                if (doctor.getId() == doctorId) {
                    // Create a simplified patient object with only necessary details
                    Patients simplifiedPatient = new Patients(
                        patient.getId(),
                        patient.getName(),
                        patient.getContactInformation(),
                        patient.getAddress(),
                        patient.getMedicalHistory(),
                        patient.getCurrentHealthStatus(),
                        null  // Avoid circular reference by setting doctors to null
                    );
                    patientsForDoctor.add(simplifiedPatient);
                }
            }
        }
        return patientsForDoctor;
    }
}
