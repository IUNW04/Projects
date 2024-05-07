/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restful.DAOS;

import restful.Models.Appointment;
import restful.Models.Doctors;
import restful.Models.Patients;

import java.util.ArrayList;
import java.util.List;
import static restful.DAOS.DAODoctor.getSimplifiedDoctors;
import static restful.DAOS.DAOPatient.getSimplifiedPatients;

public class DAOAppointment {

    private static List<Appointment> appointments = new ArrayList<>();
    private static boolean sampleDataInitialized = false; //prevents dupication

    public static void initializeSampleData() {
        if (!sampleDataInitialized) {
            // Only initialize sample data if it's not already initialized
            sampleDataInitialized = true;

            // Sample data initialization code
            List<Patients> patients = DAOPatient.getAllPatients();
            List<Doctors> doctors = DAODoctor.getAllDoctors();

            Appointment appointment1 = new Appointment();
            appointment1.setApId(305);
            appointment1.setDate("2024-05-07");
            appointment1.setTime("10:00");
            appointment1.setReason("Checkup");
            appointment1.setDuration("30 minutes");
            appointment1.setLocation("Clinic A");
            
            List<Patients> patientList1 = new ArrayList<>();
            patientList1.add(getSimplifiedPatients(patients.get(0)));
            appointment1.setPatients(patientList1);
            List<Doctors> doctorList1 = new ArrayList<>();
            doctorList1.add(getSimplifiedDoctors(doctors.get(0)));
            appointment1.setDoctors(doctorList1);

            Appointment appointment2 = new Appointment();
            appointment2.setApId(402);
            appointment2.setDate("2024-05-08");
            appointment2.setTime("14:30");
            appointment2.setReason("Dermatology Consultation");
            appointment2.setDuration("45 minutes");
            appointment2.setLocation("Clinic B");
            
            List<Patients> patientList2 = new ArrayList<>();
            patientList2.add(getSimplifiedPatients(patients.get(1)));
            appointment2.setPatients(patientList2);
            List<Doctors> doctorList2 = new ArrayList<>();
            doctorList2.add(getSimplifiedDoctors(doctors.get(1)));
            appointment2.setDoctors(doctorList2);

            appointments.add(appointment1);
            appointments.add(appointment2);
        }
    }

    public static List<Appointment> getAllAppointments() {
        return appointments;
    }

    public static Appointment getAppointmentById(int id) {
        for (Appointment appointment : appointments) {
            if (appointment.getApId() == id) {
                return appointment;
            }
        }
        return null;
    }

    public static void addAppointment(Appointment appointment) {
        for (Appointment existingAppointment : appointments) {
            if (existingAppointment.getApId() == appointment.getApId()) {
                // Appointment with the same ID already exists, return or throw an exception
                return; // or throw an exception
            }
        }
        appointments.add(appointment);
    }

    public static void updateAppointment(Appointment updatedAppointment) {
        for (int i = 0; i < appointments.size(); i++) {
            if (appointments.get(i).getApId() == updatedAppointment.getApId()) {
                appointments.set(i, updatedAppointment);
                return;
            }
        }
    }

    public static void deleteAppointment(int id) {
        appointments.removeIf(appointment -> appointment.getApId() == id);
    }




    
     public static List<Appointment> getAppointmentsByDoctorId(int doctorId) {
        List<Appointment> doctorAppointments = new ArrayList<>();
        for (Appointment appointment : appointments) {
            for (Doctors doctor : appointment.getDoctors()) {
                if (doctor.getId() == doctorId) {
                    doctorAppointments.add(appointment);
                    break;
                }
            }
        }
        return doctorAppointments;
    }

    public static List<Appointment> getAppointmentsByPatientId(int patientId) {
        List<Appointment> patientAppointments = new ArrayList<>();
        for (Appointment appointment : appointments) {
            for (Patients patient : appointment.getPatients()) {
                if (patient.getId() == patientId) {
                    patientAppointments.add(appointment);
                    break;
                }
            }
        }
        return patientAppointments;
    }

}
