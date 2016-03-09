package com.commonsware.calendarapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CalendarView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    CalendarView calendar;
    public String currentDate;
    public ScheduleEvent newEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //sets the main layout of the activity
        setContentView(R.layout.activity_main);

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
        String date = month + "/" + day + "/" + year;
        setCurrentDate(date);


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

    public void setCurrentDate(String date){
        this.currentDate = date;
    }

    public String getCurrentDate(){
        return this.currentDate;
    }

    public void setNewEvent(ScheduleEvent s){
        this.newEvent = s;
    }

}
