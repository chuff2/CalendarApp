package com.commonsware.calendarapp;


import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CalendarView;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    CalendarView calendar;
    public static String currentDate;
    public ScheduleEvent newEvent;
    public ArrayList<ScheduleEvent> events;
    public static DBHelper mydb;
    public static FragmentManager f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //sets the main layout of the activity
        setContentView(R.layout.activity_main);

        mydb = new DBHelper(this);
        //debug mode
        //this.deleteDatabase("MyDBName.db");

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

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
        String date = month + "-" + day + "-" + year;
        setCurrentDate(date);


        DayScheduleFragment newFrag = new DayScheduleFragment();
        /*
        Bundle args = new Bundle();
        args.putString("date", date);
        newFrag.setArguments(args);
        */

        //temp
        /*
        if (!mydb.insertEvent("Dinner", "5:00", "6:00", "3-9-2016")){
            Toast.makeText(this, "Failure", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this, "Success", Toast.LENGTH_LONG).show();
        }
        */

        events = mydb.getAllEventsFromDate(date);

        f = getFragmentManager();
        //launch the dayschedule fragment
        f.beginTransaction()
                .replace(R.id.dayschedule_container, newFrag)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.topbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.add_button) {
            //TODO handle addition
            AddEventFragment newFrag = new AddEventFragment();

            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.dayschedule_container, newFrag)
                    .addToBackStack(null)
                    .commit();
            //return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public DBHelper getMydb() {
        return mydb;
    }

    public void setMydb(DBHelper mydb) {
        this.mydb = mydb;
    }

    public void setCurrentDate(String date){
        this.currentDate = date;
    }

    public String getCurrentDate(){
        return this.currentDate;
    }

    public void setNewEvent(ScheduleEvent s){
        this.newEvent = s;
    }

    public ArrayList<ScheduleEvent> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<ScheduleEvent> events) {
        this.events = events;
    }
}
