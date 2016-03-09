package com.commonsware.calendarapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CalendarView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    CalendarView calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //sets the main layout of the activity
        setContentView(R.layout.activity_main);

        //launch the calendar fragment
        getFragmentManager()
                .beginTransaction()
                .add(R.id.calendar_container, new CalendarFragment())
                .addToBackStack(null)
                .commit();

        //date object that will tell the next fragment the day to pull info in for
        Calendar cal = Calendar.getInstance();
        String month = ((Integer)(cal.get(Calendar.MONTH) + 1)).toString();
        String day = ((Integer)cal.get(Calendar.DAY_OF_MONTH)).toString();
        String year = ((Integer)cal.get(Calendar.YEAR)).toString();
        String date = month + "/" + day + "/" + year;


        DayScheduleFragment newFrag = new DayScheduleFragment();
        Bundle args = new Bundle();
        args.putString("date", date);
        newFrag.setArguments(args);

        //getFragmentManager().beginTransaction().
          //      replace(R.id.dayschedule_container, newFrag).commit();

        //launch the dayschedule fragment
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.dayschedule_container, newFrag)
                .addToBackStack(null)
                .commit();
    }
}
