package restful.Models;

import java.util.List;

public interface IPatient {
    Patients getPatientById(int id);
    List<Patients> getAllPatients(); // New method
    void addPatient(Patients patient);
    void updatePatient(Patients patient);
    void deletePatient(int id);
    void addDoctorToPatient(int patientId, Doctors doctor);
    List<Doctors> getDoctorsForPatient(int patientId);
}
