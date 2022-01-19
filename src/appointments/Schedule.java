package appointments;

import java.time.LocalDate;
import java.time.LocalTime;

public class Schedule {

    private long scheduleId;
    private long doctorId;
    private LocalDate date;
    private LocalTime start;
    private LocalTime end;
    private Reminder reminder = Reminder.three_days;
    private Status status = Status.available;

    public Schedule( long doctorId, LocalDate date, LocalTime start, LocalTime end, Reminder reminder, Status status) {
        this.doctorId = doctorId;
        this.date = date;
        this.start = start;
        this.end = end;
        this.reminder = reminder;
        this.status = status;
    }

    public Schedule() {
    }

    public long getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(long ScheduleId) {
        this.scheduleId = scheduleId;
    }

    public long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(long doctorId) {
        this.doctorId = doctorId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getStart() {
        return start;
    }

    public void setStart(LocalTime start) {
        this.start = start;
    }

    public LocalTime getEnd() {
        return end;
    }

    public void setEnd(LocalTime end) {
        this.end = end;
    }

    public Reminder getReminder() {
        return reminder;
    }

    public void setReminder(Reminder reminder) {
        this.reminder = reminder;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
