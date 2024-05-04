package restful.DAOS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import restful.Models.Doctors;
import restful.Models.IDoctorDataAccess;
import restful.Models.Patients;

public class DoctorDataAccessImpl implements IDoctorDataAccess {
    private Map<Integer, Doctors> doctors = new HashMap<>();
    private Map<Integer, List<Patients>> doctorPatientsMap = new HashMap<>();

    public DoctorDataAccessImpl() {
        initializeDoctors();
    }

    private void initializeDoctors() {
        // Initialize doctors
        Doctors doctor1 = new Doctors(101, "Dr. Jeremy", "55","Male", "07444434668", "783 Juniper Street NW1 8HA", "Cardiology", "English, Spanish", "15 Years");
        Doctors doctor2 = new Doctors(102, "Dr. Raami", "35","Male", "07886578902", "456 holden Street NW1 9BA", "Dermatology", "English, Arabic, French ", "8 Years");

        doctors.put(101, doctor1);
        doctors.put(102, doctor2);

        // Sample patients for doctors
        List<Patients> patientsForDoctor1 = new ArrayList<>();
        patientsForDoctor1.add(new Patients(1, "Mohammed Naahid", "20", "Male", "07456785667"));
        patientsForDoctor1.add(new Patients(2, "Zaahir Uddin", "25", "Male", "07409895691"));
        patientsForDoctor1.add(new Patients(3, "Hannah Maddison", "30", "Female", "07489701221"));
        
        List<Patients> patientsForDoctor2 = new ArrayList<>();
        patientsForDoctor2.add(new Patients(4, "Nihan Miah", "20", "Male", "07456782232"));
        patientsForDoctor2.add(new Patients(5, "Ashraf Islam", "18", "Male", "07456789980"));

        doctorPatientsMap.put(101, patientsForDoctor1);
        doctorPatientsMap.put(102, patientsForDoctor2);

        // Assign patients to doctors
        for (Map.Entry<Integer, Doctors> entry : doctors.entrySet()) {
            int doctorId = entry.getKey();
            Doctors doctor = entry.getValue();
            List<Patients> assignedPatients = doctorPatientsMap.getOrDefault(doctorId, new ArrayList<>());
            doctor.setPatients(assignedPatients);
        }
    }

    @Override
    public Doctors getDoctorById(int id) {
        return doctors.get(id);
    }

    @Override
    public List<Doctors> getAllDoctors() {
        return new ArrayList<>(doctors.values());
    }

    @Override
    public void addDoctor(Doctors doctor) {
        doctors.put(doctor.getId(), doctor);
        doctorPatientsMap.put(doctor.getId(), new ArrayList<>());
    }

    @Override
    public void updateDoctor(Doctors doctor) {
        doctors.put(doctor.getId(), doctor);
    }

    @Override
    public void deleteDoctor(int id) {
        doctors.remove(id);
        doctorPatientsMap.remove(id);
    }

    public void addPatientToDoctor(int doctorId, Patients patient) {
        if (doctors.containsKey(doctorId)) {
            doctorPatientsMap.get(doctorId).add(patient);
        }
    }

    public List<Patients> getPatientsForDoctor(int doctorId) {
        return doctorPatientsMap.getOrDefault(doctorId, new ArrayList<>());
    }
}
