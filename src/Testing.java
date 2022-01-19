import Exceptions.EmailException;
import Exceptions.PasswordException;
import GUI.Login;
import appointments.*;
import user.Admin.Admin;
import user.Admin.AdminDAOImp;
import user.Doctor.Doctor;
import user.Doctor.DoctorDAOImp;
import user.Doctor.Specialization;
import user.Patient.InsuranceType;
import user.Patient.*;
import user.Patient.PatientDAOImp;

import java.io.File;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Testing {

    public static void main(String[] args) throws SQLException {
        /*Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ehealth", "root", "MySQL640182--");
        Blob b1 = conn.createBlob();
        Appointment appointment = new Appointment(4, 5, 2, 1, "headache", b1, 10);

        List<Appointment> list = new ArrayList<>();
        AppointmentDAOImp appointmentDAOImp = new AppointmentDAOImp();
        try {
            appointmentDAOImp.getAll();
            System.out.println(list);
            for (Appointment app: list
                 ) {
                System.out.println(app.getHealthProblem());
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }*/
/*
        PatientDAOImp patientDAOImp=new PatientDAOImp();
        Patient patient=new Patient(
                "ahmed11",
        )
        patients=patientDAOImp.getAll();
*/
    }

}