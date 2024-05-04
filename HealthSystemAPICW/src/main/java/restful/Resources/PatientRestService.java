package restful.Resources;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
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
    @Path("/{patientId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Patients getPatientById(@PathParam("patientId") int patientId) {
        return DAOPatient.getPatientById(patientId);
    }
}