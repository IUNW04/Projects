/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restful.Resources;

import restful.DAOS.DAOAppointment;
import restful.Models.Appointment;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/appointments")
public class AppointmentRestService {

    private DAOAppointment appointmentDAO;

    public AppointmentRestService() {
        this.appointmentDAO = new DAOAppointment();
        this.appointmentDAO.initializeSampleData(); // Initialize sample data
    }

    public AppointmentRestService(DAOAppointment appointmentDAO) {
        this.appointmentDAO = appointmentDAO;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Appointment> getAllAppointments() {
        return appointmentDAO.getAllAppointments();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Appointment getAppointmentById(@PathParam("id") int id) {
        return appointmentDAO.getAppointmentById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addAppointment(Appointment appointment) {
        appointmentDAO.addAppointment(appointment);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateAppointment(@PathParam("id") int id, Appointment updatedAppointment) {
        updatedAppointment.setApId(id); // Ensure the ID in the path matches the ID in the object
        appointmentDAO.updateAppointment(updatedAppointment);
    }

    @DELETE
    @Path("/{id}")
    public void deleteAppointment(@PathParam("id") int id) {
        appointmentDAO.deleteAppointment(id);
    }
    
        @GET
    @Path("/doctors/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Appointment> getAppointmentsByDoctorId(@PathParam("id") int doctorId) {
        return DAOAppointment.getAppointmentsByDoctorId(doctorId);
    }

    @GET
    @Path("/patients/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Appointment> getAppointmentsByPatientId(@PathParam("id") int patientId) {
        return DAOAppointment.getAppointmentsByPatientId(patientId);
    }

}

