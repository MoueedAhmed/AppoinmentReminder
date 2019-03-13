package com.example.appointmentreminder;

import android.os.Parcel;
import android.os.Parcelable;

public class Appointment implements Parcelable {

    public String name;
    public String type;
    public String monthDate;
    public int dayDate;
    public int yearDate;
    public int hourTime;
    public String minuteTime;
    public String AMorPMTime;

    public Appointment(String passedAppointmentName, String passedAppointType,
                       String passedAppointmentDateMonth, int passedAppointmentDateDay, int passedAppointmentDateYear,
                       int passedAppointmentTimeHour, String passedAppointmentTimeMinute, String passedAppointmentTimeAMorPM){
        name = passedAppointmentName;
        type = passedAppointType;
        monthDate = passedAppointmentDateMonth;
        dayDate = passedAppointmentDateDay;
        yearDate = passedAppointmentDateYear;
        hourTime = passedAppointmentTimeHour;
        minuteTime = passedAppointmentTimeMinute;
        AMorPMTime = passedAppointmentTimeAMorPM;
    }
    protected Appointment(Parcel in)
    {
        name = in.readString();
        type = in.readString();
        monthDate = in.readString();
        dayDate = in.readInt();
        yearDate = in.readInt();
        hourTime = in.readInt();
        minuteTime = in.readString();
        AMorPMTime = in.readString();
    }

    public static final Creator<Appointment> CREATOR = new Creator<Appointment>() {
        @Override
        public Appointment createFromParcel(Parcel in) {
            return new Appointment(in);
        }

        @Override
        public Appointment[] newArray(int size) {
            return new Appointment[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(type);
        dest.writeString(monthDate);
        dest.writeInt(dayDate);
        dest.writeInt(yearDate);
        dest.writeInt(hourTime);
        dest.writeString(minuteTime);
        dest.writeString(AMorPMTime);
    }

}