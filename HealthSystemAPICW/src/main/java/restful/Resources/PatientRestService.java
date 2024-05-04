package restful.Resources;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import restful.DAOS.DAOPatient;
import restful.Models.IPatient;
import restful.Models.Patients;

@Path("/patients")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PatientRestService {
    private final IPatient patientDataAccess = new DAOPatient();

    @GET
    public List<Patients> getAllPatients() {
        return patientDataAccess.getAllPatients();
    }

    @GET
    @Path("/{id}")
    public Patients getPatientById(@PathParam("id") int id) {
        return patientDataAccess.getPatientById(id);
    }

    @POST
    public void addPatient(Patients patient) {
        patientDataAccess.addPatient(patient);
    }

    @PUT
    @Path("/{id}")
    public void updatePatient(@PathParam("id") int id, Patients updatedPatient) {
        Patients existingPatient = patientDataAccess.getPatientById(id);
        if (existingPatient != null) {
            updatedPatient.setId(id);
            patientDataAccess.updatePatient(updatedPatient);
        }
    }

    @DELETE
    @Path("/{id}")
    public void deletePatient(@PathParam("id") int id) {
        patientDataAccess.deletePatient(id);
    }
}
