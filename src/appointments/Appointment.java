package appointments;

import java.sql.Blob;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalTime;

public class Appointment {

    private long id;
    private long doctorId;
    private long patientId;
    private long scheduleId;
    private String healthProblem;
    private Blob healthInfo;
    private int distanceOfSearch = 10;

    public Appointment() {
    }

    public Appointment(long id,
                       long doctorId,
                       long patientId,
                       long scheduleId,
                       String healthProblem,
                       Blob healthInfo,
                       int distanceOfSearch) {
        this.id = id;
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.scheduleId = scheduleId;
        this.healthProblem = healthProblem;
        this.healthInfo = healthInfo;
        this.distanceOfSearch = distanceOfSearch;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(long doctorId) {
        this.doctorId = doctorId;
    }

    public long getPatientId() {
        return patientId;
    }

    public void setPatientId(long patientId) {
        this.patientId = patientId;
    }

    public long getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(long scheduleId) {
        this.scheduleId = scheduleId;
    }

    public String getHealthProblem() {
        return healthProblem;
    }

    public void setHealthProblem(String healthProblem) {
        this.healthProblem = healthProblem;
    }

    public Blob getHealthInfo() {
        return healthInfo;
    }

    public void setHealthInfo(Blob healthInfo) {
        this.healthInfo = healthInfo;
    }

    public int getDistanceOfSearch() {
        return distanceOfSearch;
    }

    public void setDistanceOfSearch(int distanceOfSearch) {
        this.distanceOfSearch = distanceOfSearch;
    }

}
