package com.example.appointmentreminder;

public class Appoinment {

    private  String name;
    private  String type;
    private int dayDate;
    private int yearDate;
    private  String monthDate;
    private int hourTime;
    private int minuteTime;
    private String AMorPMTime;

    public Appoinment(String name, String type, int dayDate, int yearDate, String monthDate,
                      int hourTime, int minuteTime, String AMorPMTime) {
        this.name = name;
        this.type = type;
        this.dayDate = dayDate;
        this.yearDate = yearDate;
        this.monthDate = monthDate;
        this.hourTime = hourTime;
        this.minuteTime = minuteTime;
        this.AMorPMTime = AMorPMTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDayDate() {
        return dayDate;
    }

    public void setDayDate(int dayDate) {
        this.dayDate = dayDate;
    }

    public int getYearDate() {
        return yearDate;
    }

    public void setYearDate(int yearDate) {
        this.yearDate = yearDate;
    }

    public String getMonthDate() {
        return monthDate;
    }

    public void setMonthDate(String monthDate) {
        this.monthDate = monthDate;
    }

    public int getHourTime() {
        return hourTime;
    }

    public void setHourTime(int hourTime) {
        this.hourTime = hourTime;
    }

    public int getMinuteTime() {
        return minuteTime;
    }

    public void setMinuteTime(int minuteTime) {
        this.minuteTime = minuteTime;
    }

    public String getAMorPMTime() {
        return AMorPMTime;
    }

    public void setAMorPMTime(String AMorPMTime) {
        this.AMorPMTime = AMorPMTime;
    }
}
