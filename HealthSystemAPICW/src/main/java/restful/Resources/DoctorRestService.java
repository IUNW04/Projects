package restful.Resources;
import java.util.ArrayList;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import restful.DAOS.DAODoctor;
import restful.DAOS.DAOPatient;

import restful.Models.Doctors;
import restful.Models.Patients;

@Path("/doctors")
public class DoctorRestService {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Doctors> getAllDoctors() {
        return DAODoctor.getAllDoctors();
    }

    @GET
    @Path("/{doctorId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Doctors getDoctorById(@PathParam("doctorId") int doctorId) {
        return DAODoctor.getDoctorById(doctorId);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addDoctor(Doctors doctor) {
        DAODoctor.addDoctor(doctor);
    }

    @PUT
    @Path("/{doctorId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateDoctor(@PathParam("doctorId") int doctorId, Doctors updatedDoctor) {
        updatedDoctor.setId(doctorId); // Ensure the ID in the path matches the ID in the object
        DAODoctor.updateDoctor(updatedDoctor);
    }

    @DELETE
    @Path("/{doctorId}")
    public void deleteDoctor(@PathParam("doctorId") int doctorId) {
        DAODoctor.deleteDoctor(doctorId);
    }
@GET
    @Path("/patients/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Doctors> getDoctorsByPatientId(@PathParam("id") int patientId) {
        List<Doctors> doctorsForPatient = new ArrayList<>();
        Patients patient = DAOPatient.getPatientById(patientId);
        if (patient != null) {
            List<Doctors> doctors = patient.getDoctors();
            doctorsForPatient.addAll(doctors);
        }
        return doctorsForPatient;
    }
}
