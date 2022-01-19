package appointments;

import Connection.DBConnection;
import javax.swing.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDAOImp implements AppointmentDAO{

    @Override
    public void addAppointment(Appointment appointment) {
            try{
                Connection con= DBConnection.getConnection();
                String sql = "INSERT INTO `appointments`( `doctorId`, `patientId`,`scheduleId`,`healthproblem`, `healthinfo`, `distanceofsearch`) VALUES (?,?,?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setLong(1, appointment.getDoctorId());
                ps.setLong(2, appointment.getPatientId());
                ps.setLong(3,appointment.getScheduleId());
                ps.setString(4,appointment.getHealthProblem());
                ps.setBlob(5, appointment.getHealthInfo());
                ps.setInt(6, appointment.getDistanceOfSearch());

                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Appointment booked!");
            }catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error");
            }


    }

    @Override
    public void shiftAppointmentById(long appointmentId, long scheduleId) {
        try{
            Connection con= DBConnection.getConnection();
            String sql = "Update appointments set scheduleId=? where id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, scheduleId);
            ps.setLong(2, appointmentId);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Appointment shifted!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
    }

    @Override
    public void cancel(Appointment appointment) {
        try{
            Connection con= DBConnection.getConnection();
            String sql = "delete from appointments where doctorId=? , patientId=?, scheduleId=?" +
                    "healthproblem=?, healthinfo=?, distanceofsearch=? ";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setLong(1, appointment.getDoctorId());
            ps.setLong(2, appointment.getPatientId());
            ps.setLong(3,appointment.getScheduleId());
            ps.setString(4,appointment.getHealthProblem());
            //ps.setString(7, appointment.getHealthInfo().getAbsolutePath());
            ps.setBlob(5,appointment.getHealthInfo());
            ps.setInt(6, appointment.getDistanceOfSearch());

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Appointment deleted");
        }catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
    }


    @Override
    public void cancelById(long id) {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "delete from appointments where id=" + id;
            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Appointment deleted");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
    }


        @Override
    public Appointment getAppointmentByPatientId(long patientId) {
            Appointment appointment = new Appointment();
            try {
                Connection con = DBConnection.getConnection();
                String sql = "SELECT * from appointments where patientId="+patientId;
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs=ps.executeQuery();
                if(rs.next()){
                    appointment.setId(rs.getLong("id"));
                    appointment.setDoctorId(rs.getLong("doctorId"));
                    appointment.setPatientId(rs.getLong("patientId"));
                    appointment.setScheduleId(rs.getLong("scheduleId"));
                    appointment.setHealthProblem(rs.getString("healthProblem"));
                    appointment.setHealthInfo(rs.getBlob("healthInfo"));
                    appointment.setDistanceOfSearch(rs.getInt("distanceOfSearch"));
                }
                //JOptionPane.showMessageDialog(null, "Deleted!");
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error");
            }
            return appointment;
    }

    @Override
    public Appointment getAppointmentByDoctorId(long doctorId) {
        Appointment appointment = new Appointment();
        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT * from appointments where doctorId="+doctorId;
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                appointment.setId(rs.getLong("id"));
                appointment.setDoctorId(rs.getLong("doctorId"));
                appointment.setPatientId(rs.getLong("patientId"));
                appointment.setScheduleId(rs.getLong("scheduleId"));
                appointment.setHealthProblem(rs.getString("healthProblem"));
                appointment.setHealthInfo(rs.getBlob("healthInfo"));
                appointment.setDistanceOfSearch(rs.getInt("distanceOfSearch"));
            }
            //JOptionPane.showMessageDialog(null, "Deleted!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
        return appointment;
    }

    @Override
    public Appointment getById(int id) {
        Appointment appointment = new Appointment();
        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT * from appointments where id="+id;
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                appointment.setId(rs.getLong("id"));
                appointment.setDoctorId(rs.getLong("doctorId"));
                appointment.setPatientId(rs.getLong("patientId"));
                appointment.setScheduleId(rs.getLong("scheduleId"));
                appointment.setHealthProblem(rs.getString("healthProblem"));
                appointment.setHealthInfo(rs.getBlob("healthInfo"));
                appointment.setDistanceOfSearch(rs.getInt("distanceOfSearch"));
            }
            //JOptionPane.showMessageDialog(null, "Deleted!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
        return appointment;
    }

    @Override
    public List<Appointment> getAll() {
        List<Appointment> list = new ArrayList<>();
        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT * FROM appointments ";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Appointment appointment = new Appointment();
                appointment.setId(rs.getLong("id"));
                appointment.setDoctorId(rs.getLong("doctorId"));
                appointment.setPatientId(rs.getLong("patientId"));
                appointment.setScheduleId(rs.getLong("scheduleId"));
                appointment.setHealthProblem(rs.getString("healthProblem"));
                appointment.setHealthInfo(rs.getBlob("healthInfo"));
                appointment.setDistanceOfSearch(rs.getInt("distanceOfSearch"));
                list.add(appointment);
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
        return list;
    }

    @Override
    public List<Appointment> getAllByDoctorId(long doctorId) {
        List<Appointment> list = new ArrayList<>();
        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT * FROM appointments WHERE doctorId="+doctorId;
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Appointment appointment = new Appointment();
                appointment.setId(rs.getLong("id"));
                appointment.setDoctorId(rs.getLong("doctorId"));
                appointment.setPatientId(rs.getLong("patientId"));
                appointment.setScheduleId(rs.getLong("scheduleId"));
                appointment.setHealthProblem(rs.getString("healthProblem"));
                appointment.setHealthInfo(rs.getBlob("healthInfo"));
                appointment.setDistanceOfSearch(rs.getInt("distanceOfSearch"));
                list.add(appointment);
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
        return list;
    }

    @Override
    public List<Appointment> getAllByPatientId(long patientId) {
        List<Appointment> list = new ArrayList<>();
        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT * FROM appointments WHERE patientId="+patientId;
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Appointment appointment = new Appointment();
                appointment.setId(rs.getLong("id"));
                appointment.setDoctorId(rs.getLong("doctorId"));
                appointment.setPatientId(rs.getLong("patientId"));
                appointment.setScheduleId(rs.getLong("scheduleId"));
                appointment.setHealthProblem(rs.getString("healthProblem"));
                appointment.setHealthInfo(rs.getBlob("healthInfo"));
                appointment.setDistanceOfSearch(rs.getInt("distanceOfSearch"));
                list.add(appointment);
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
        return list;
    }
}