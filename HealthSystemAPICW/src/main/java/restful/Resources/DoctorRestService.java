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
}
