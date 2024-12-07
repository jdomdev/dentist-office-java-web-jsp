package io.sunbit.dentistoffice.logic;

import java.time.LocalDateTime;


public class Schedule {
    // Attributes
    private long scheduleId;
    private LocalDateTime startSchedule;
    private LocalDateTime endSchedule;
    // Constructors
    public Schedule() {
    }
    public Schedule(long scheduleId, LocalDateTime startSchedule, LocalDateTime endSchedule) {
        this.scheduleId = scheduleId;
        this.startSchedule = startSchedule;
        this.endSchedule = endSchedule;
    }
    // Setters
    public void setScheduledId(long scheduleId) {
        this.scheduleId = scheduleId;
    }
    public void setStartSchedule(LocalDateTime startSchedule) {
        this.startSchedule = startSchedule;
    }
    public void setEndSchedule(LocalDateTime endSchedule) {
        this.endSchedule = endSchedule;
    }
    // Getters
    public long getScheduleId() {
        return scheduleId;
    }
    public LocalDateTime getStartSchedule() {
        return startSchedule;
    }
    public LocalDateTime getEndSchedule() {
        return endSchedule;
    }
    
}
