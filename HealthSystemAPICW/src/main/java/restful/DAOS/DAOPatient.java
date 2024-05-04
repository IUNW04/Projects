package restful.DAOS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import restful.Models.Doctors;
import restful.Models.IPatient;
import restful.Models.Patients;

public class DAOPatient implements IPatient {
    private Map<Integer, Patients> patients = new HashMap<>();
    private Map<Integer, List<Doctors>> patientDoctorsMap = new HashMap<>();

    public DAOPatient() {
        initializePatients();
    }

    private void initializePatients() {
        // Initialize patients
        Patients patient1 = new Patients(1, "Mohammed Naahid", "20", "Male", "07456785667", "123 Elm St", "Allergic to peanuts", "Stable");
        Patients patient2 = new Patients(2, "Zaahir Uddin", "25", "Male", "07409895691", "456 Oak St", "Asthma", "Improving");
        Patients patient3 = new Patients(3, "Hannah Maddison", "30", "Female", "07489701221", "789 Maple St", "Diabetes", "Stable");
        Patients patient4 = new Patients(4, "Nihan Miah", "20", "Male", "07456782232", "101 Pine St", "High blood pressure", "Improving");
        Patients patient5 = new Patients(5, "Ashraf Islam", "18", "Male", "07456789980", "101 Pine St", "High blood pressure", "Improving");
        patients.put(1, patient1);
        patients.put(2, patient2);
        patients.put(3, patient3);
        patients.put(4, patient4);
        patients.put(5, patient5);

        // Sample doctors for patients
        List<Doctors> doctorsForPatient1 = new ArrayList<>();
        doctorsForPatient1.add(new Doctors(101, "Dr. Jeremy", "07444434668", "Cardiology", "English, Spanish", "15 Years"));
         doctorsForPatient1.add(new Doctors(102, "Dr. Raami", "07886578902", "Dermatology", "English, Arabic, French ", "8 Years"));
        List<Doctors> doctorsForPatient2 = new ArrayList<>();
        doctorsForPatient2.add(new Doctors(101, "Dr. Jeremy", "07444434668", "Cardiology", "English, Spanish", "15 Years"));

        List<Doctors> doctorsForPatient3 = new ArrayList<>();
        doctorsForPatient3.add(new Doctors(101, "Dr. Jeremy", "07444434668", "Cardiology", "English, Spanish", "15 Years"));

        List<Doctors> doctorsForPatient4 = new ArrayList<>();
        doctorsForPatient4.add(new Doctors(102, "Dr. Raami", "07886578902", "Dermatology", "English, Arabic, French ", "8 Years"));

        List<Doctors> doctorsForPatient5 = new ArrayList<>();
        doctorsForPatient5.add(new Doctors(102, "Dr. Raami", "07886578902", "Dermatology", "English, Arabic, French ", "8 Years"));
        
        
        patientDoctorsMap.put(1, doctorsForPatient1);
        patientDoctorsMap.put(2, doctorsForPatient2);
        patientDoctorsMap.put(3, doctorsForPatient3);
        patientDoctorsMap.put(4, doctorsForPatient4);
        patientDoctorsMap.put(5, doctorsForPatient5);

        // Assign doctors to patients
        for (Map.Entry<Integer, Patients> entry : patients.entrySet()) {
            int patientId = entry.getKey();
            Patients patient = entry.getValue();
            List<Doctors> assignedDoctors = patientDoctorsMap.getOrDefault(patientId, new ArrayList<>());
            patient.setDoctors(assignedDoctors);
        }
    }

    @Override
    public Patients getPatientById(int id) {
        return patients.get(id);
    }

    @Override
    public List<Patients> getAllPatients() {
        return new ArrayList<>(patients.values());
    }

    @Override
    public void addPatient(Patients patient) {
        patients.put(patient.getId(), patient);
        patientDoctorsMap.put(patient.getId(), new ArrayList<>());
    }

    @Override
    public void updatePatient(Patients patient) {
        patients.put(patient.getId(), patient);
    }

    @Override
    public void deletePatient(int id) {
        patients.remove(id);
        patientDoctorsMap.remove(id);
    }

    public void addDoctorToPatient(int patientId, Doctors doctor) {
        if (patients.containsKey(patientId)) {
            patientDoctorsMap.get(patientId).add(doctor);
        }
    }

    public List<Doctors> getDoctorsForPatient(int patientId) {
        return patientDoctorsMap.getOrDefault(patientId, new ArrayList<>());
    }
}
