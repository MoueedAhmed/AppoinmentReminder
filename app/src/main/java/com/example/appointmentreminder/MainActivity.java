package com.example.appointmentreminder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    public ArrayList<Appointment> appointmentArrayList = new ArrayList<Appointment>();
    Button buttonAddAppoinmentMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonAddAppoinmentMain = findViewById(R.id.buttonAddAppoinmentMain);
        buttonAddAppoinmentMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(MainActivity.this, AddAppointmentActivity.class),1);
            }
        });

        //populate some test data to display in table rows
        if (savedInstanceState == null) {
            CreateSomeTestAppointmentsToStartWith();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList("Appointment_Array_List", appointmentArrayList);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState)
    {
        super.onRestoreInstanceState(savedInstanceState);

        appointmentArrayList = savedInstanceState.getParcelableArrayList("Appointment_Array_List");

        for(int i = 0; i < appointmentArrayList.size();i++) {
            PopulateTable(i);
        }
    }

    //Helper method to populate test data
    private void CreateSomeTestAppointmentsToStartWith() {
        appointmentArrayList.add(new Appointment("Doctors Visit","Health", "Oct", 9, 2016, 9, "00", "AM"));
        appointmentArrayList.add(new Appointment("Hair Cut appointment","Personal","Oct", 10, 2016,9,"00","AM"));
        appointmentArrayList.add(new Appointment("Meeting with Accountant","Personal","Oct", 11, 2016,11,"00","AM"));
        appointmentArrayList.add(new Appointment("Boss/HR Meeting","Work","Oct", 12, 2016,2,"00","PM"));
        appointmentArrayList.add(new Appointment("Teacher Conference","School","Nov", 1, 2016,9,"00","AM"));
        appointmentArrayList.add(new Appointment("Dentist For Son","Health","Nov", 1, 2016,9,"00","AM"));
        appointmentArrayList.add(new Appointment("Dinner With Friends","Other","Mar", 8, 2019,9,"00","AM"));

        for(int i = 0; i < appointmentArrayList.size(); i++){
            PopulateTable(i);
        }
    }

    //helper method used with CreateSomeTestAppointmentsToStartWith()
    private void PopulateTable(int arrayListCounter) {
        TableLayout appointmentTBL = (TableLayout) findViewById(R.id.tableLayoutMain);

        TableRow newTableRow = new TableRow(this);;
        newTableRow.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));

        TextView txtvName = new TextView(this);
        txtvName.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT,1.0f));
        txtvName.setGravity(Gravity.CENTER);
        txtvName.setText(appointmentArrayList.get(arrayListCounter).name);

        TextView txtvType = new TextView(this);
        txtvType.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT,1.0f));

        txtvType.setGravity(Gravity.CENTER);
        txtvType.setText(appointmentArrayList.get(arrayListCounter).type);


        TextView txtvDate = new TextView(this);
        txtvDate.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT,1.0f));
        txtvDate.setGravity(Gravity.CENTER);
        txtvDate.setText(SetToDateAndTime(appointmentArrayList.get(arrayListCounter)));

        newTableRow.addView(txtvName);
        newTableRow.addView(txtvType);
        newTableRow.addView(txtvDate);
        appointmentTBL.addView(newTableRow,arrayListCounter+1);
    }

    //helper method used with CreateSomeTestAppointmentsToStartWith(), used to get date or time returns as String
    private String SetToDateAndTime(Appointment appointment){
        long currentDateAndTime = System.currentTimeMillis(); //Todays Date
        SimpleDateFormat formatDate = new SimpleDateFormat("MMM d, yyyy"); //Date Format
        String todaysDate = formatDate.format(currentDateAndTime); //Today's date formated
        String passDate = appointment.monthDate +" " + appointment.dayDate +", " + appointment.yearDate; //Tasks date formated the same way

        if(Objects.equals(todaysDate, passDate)){ //Compare today's date and passed date, return time if dates match
            return appointment.hourTime +":" +appointment.minuteTime +" " +appointment.AMorPMTime;
        }
        return appointment.monthDate +" " + appointment.dayDate +", " + appointment.yearDate; //Otherwise, return the date

    }

    //Returns information passed from addAppointmentActivity
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if(resultCode == RESULT_OK) {

                //Creates a new appointment with the information passed
                appointmentArrayList.add(new Appointment(
                        data.getStringExtra("name"),data.getStringExtra("type"),
                        data.getStringExtra("monthOfYear"), data.getIntExtra("dayOfMonth", 0), data.getIntExtra("year", 1111),
                        data.getIntExtra("hour", 11),data.getStringExtra("minute"),data.getStringExtra("AMorPM")));
                //Displays new appointment on in the table
                PopulateTable(appointmentArrayList.size()-1);
            }
        }
    }
}
