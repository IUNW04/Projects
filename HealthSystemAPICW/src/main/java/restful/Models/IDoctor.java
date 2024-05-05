package restful.Models;

import java.util.List;

public interface IDoctor{
    Doctors getDoctorById(int id);
    List<Doctors> getAllDoctors(); 
    void addDoctor(Doctors doctor);
    void updateDoctor(Doctors doctor);
    void deleteDoctor(int id);
}
