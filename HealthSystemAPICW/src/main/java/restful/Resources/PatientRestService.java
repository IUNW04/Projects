package restful.Resources;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import restful.DAOS.DAODoctor;
import restful.DAOS.DAOPatient;
import restful.Models.Patients;

@Path("/patients")
public class PatientRestService {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Patients> getAllPatients() {
        return DAOPatient.getAllPatients();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Patients getPatientById(@PathParam("id") int id) {
        return DAOPatient.getPatientById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addPatient(Patients patient) {
        DAOPatient.addPatient(patient);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updatePatient(@PathParam("id") int id, Patients updatedPatient) {
        Patients existingPatient = DAOPatient.getPatientById(id);
        if (existingPatient != null) {
            updatedPatient.setId(id);
            DAOPatient.updatePatient(updatedPatient);
        }
    }

    @DELETE
    @Path("/{id}")
    public void deletePatient(@PathParam("id") int id) {
        DAOPatient.deletePatient(id);
    }
    
    
    @GET
    @Path("/doctors/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Patients> getPatientsByDoctorId(@PathParam("id") int doctorId) {
        return DAODoctor.getPatientsForDoctor(doctorId);
    }
    
    
}