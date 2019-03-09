package com.example.appointmentreminder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

public class AddAppointmentActivity extends AppCompatActivity {

    TextView txtDate;
    TextView txtTime;

    private int year;
    private int month;
    private int day;

    private int hour;
    private int minute;

    static final int DATE_DIALOG_ID = 999;
    static final int TIME_DIALOG_ID = 998;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_appointment);

        txtDate = findViewById(R.id.textViewDate);
        txtTime = findViewById(R.id.textViewTime);
        //set current date and time
        setCurrentDateAndTimeOnView();
    }

    //helper method to set current date and time
    public void setCurrentDateAndTimeOnView() {

        final Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);

        hour = c.get(Calendar.HOUR_OF_DAY);
        minute = c.get(Calendar.MINUTE);

        // set current time into textview
        txtTime.setText(new StringBuilder().append(pad(hour))
                .append(":").append(pad(minute)));

        // set current date into textview
        txtDate.setText(new StringBuilder()
                // Month is 0 based, just add 1
                .append(month + 1).append("-").append(day).append("-")
                .append(year).append(" "));
    }

    //Helper method used in setCurrentDateAndTimeOnView()
    private String pad(int c) {
        if (c >= 10)
            return String.valueOf(c);
        else
            return "0" + String.valueOf(c);
    }

}
