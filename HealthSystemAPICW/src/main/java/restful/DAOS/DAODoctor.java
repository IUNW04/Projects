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
        Doctors doctor1 = new Doctors(101, "Dr. Jeremy", "55", "07444434668", "783 Juniper Street NW1 8HA", "Cardiology", "English, French, Arabic", "10 years", null);
        Doctors doctor2 = new Doctors(102, "Dr. Raami", "50", "07886578902", "456 holden Street NW1 9BA", "Dermatology", "English, Spanish", "5 years", null);
        // Associate patients with doctors
        doctor1.setPatients(getPatientsForDoctor(101));
        doctor2.setPatients(getPatientsForDoctor(102));

        doctors.add(doctor1);
        doctors.add(doctor2);
    }

    public static List<Doctors> getAllDoctors() {
        return doctors;
    }

    public static Doctors getDoctorById(int id) {
        for (Doctors doctor : doctors) {
            if (doctor.getId() == id) {
                return doctor;
            }
        }
        return null;
    }

    public static void addDoctor(Doctors doctor) {
        doctors.add(doctor);
    }

    public static void updateDoctor(Doctors updatedDoctor) {
        for (int i = 0; i < doctors.size(); i++) {
            if (doctors.get(i).getId() == updatedDoctor.getId()) {
                doctors.set(i, updatedDoctor);
                return;
            }
        }
    }

    public static void deleteDoctor(int id) {
        doctors.removeIf(doctor -> doctor.getId() == id);
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
                            null,
                            patient.getContactInformation(),
                            null,
                            patient.getMedicalHistory(),
                            patient.getCurrentHealthStatus(),
                            null  
                    );
                    patientsForDoctor.add(simplifiedPatient);
                }
            }
        }
        return patientsForDoctor;
    }
}
