package com.commonsware.calendarapp;

/**
 * Created by connerhuff on 3/8/16.
 */
public class ScheduleEvent {

    private String eventName;
    private String startTime;
    private String endTime;

    public ScheduleEvent (String eventName, String startTime, String endTime){
        this.eventName = eventName;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
