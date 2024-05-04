package restful.Resources;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import restful.DAOS.DAODoctor;
import restful.Models.Doctors;

@Path("/doctors")
public class DoctorRestService {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Doctors> getAllDoctors() {
        return DAODoctor.getDoctors();
    }

    @GET
    @Path("/{doctorId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Doctors getDoctorById(@PathParam("doctorId") int doctorId) {
        return DAODoctor.getDoctorById(doctorId);
    }
}