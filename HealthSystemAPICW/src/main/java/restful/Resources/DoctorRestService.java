package restful.Resources;

import restful.Models.Doctors;
import restful.DAOS.DoctorDataAccessImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/doctors")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DoctorRestService {
    private final DoctorDataAccessImpl doctorDataAccess = new DoctorDataAccessImpl();

    @GET
    public List<Doctors> getAllDoctors() {
        return doctorDataAccess.getAllDoctors();
    }

    @GET
    @Path("/{id}")
    public Doctors getDoctorById(@PathParam("id") int id) {
        return doctorDataAccess.getDoctorById(id);
    }

    @POST
    public void addDoctor(Doctors doctor) {
        doctorDataAccess.addDoctor(doctor);
    }

    @PUT
    @Path("/{id}")
    public void updateDoctor(@PathParam("id") int id, Doctors updatedDoctor) {
        Doctors existingDoctor = doctorDataAccess.getDoctorById(id);
        if (existingDoctor != null) {
            updatedDoctor.setId(id);
            doctorDataAccess.updateDoctor(updatedDoctor);
        }
    }

    @DELETE
    @Path("/{id}")
    public void deleteDoctor(@PathParam("id") int id) {
        doctorDataAccess.deleteDoctor(id);
    }
}
