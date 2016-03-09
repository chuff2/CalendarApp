package com.commonsware.calendarapp;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.CalendarView.OnDateChangeListener;
import android.widget.Toast;

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

        //launch the dayschedule fragment
        getFragmentManager()
                .beginTransaction()
                .add(R.id.dayschedule_container, new DayScheduleFragment())
                .addToBackStack(null)
                .commit();
    }
}
