package appointments;

import Exceptions.EmailException;
import Exceptions.PasswordException;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface AppointmentDAO {
    public void addAppointment(Appointment appointment);
    public void shiftAppointmentById(long appointmentId, long scheduleId);
    public void cancel(Appointment appointment);
    public void cancelById(long id);
    //public boolean existsAppointment(long AppointmentId);
    public Appointment getAppointmentByPatientId(long patientId);
    public Appointment getAppointmentByDoctorId(long doctorId);
    public Appointment getById(int id);
    public List<Appointment> getAll();
    public List<Appointment> getAllByDoctorId(long doctorId);
    public List<Appointment> getAllByPatientId(long patientId);
}
