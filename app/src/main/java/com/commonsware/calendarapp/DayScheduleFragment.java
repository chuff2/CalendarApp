package com.commonsware.calendarapp;

import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by connerhuff on 3/8/16.
 */
public class DayScheduleFragment extends ListFragment {

    private String data;//the date that is given to us from CalendarFragment/MainActivity
    private ArrayList<ScheduleEvent> events;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //temporary stuff
        /*
        events = new ArrayList<ScheduleEvent>();
        events.add(new ScheduleEvent("DinnerDinnerDinnerDinner", "3:30", "5:00", ""));
        events.add(new ScheduleEvent("Breakfast", "10:00", "7:00", ""));
        events.add(new ScheduleEvent("Dinner", "3:30", "5:00", ""));
        events.add(new ScheduleEvent("Breakfast", "10:00", "7:00", ""));
        events.add(new ScheduleEvent("Dinner", "3:30", "5:00", ""));
        events.add(new ScheduleEvent("Breakfast", "10:00", "7:00", ""));
        */
        String date = ((MainActivity) getActivity()).getCurrentDate();
        events = ((MainActivity) getActivity()).getMydb().getAllEventsFromDate(date);



    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Context a = getActivity();
        setListAdapter(new MyCustomAdapter(getActivity(), events));
        getListView().setDivider(null);
    }

    /*
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (getArguments() != null)
            data = getArguments().getString("date");

        return inflater.inflate(R.layout.fragment_dayschedule, container, false);
    }
    */


    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        // retrieve theListView item
        ScheduleEvent item = events.get(position);

        events.remove(position);
        ((MainActivity) getActivity()).getMydb().deleteEvent(item.getId());

        DayScheduleFragment newFrag = new DayScheduleFragment();
        getFragmentManager().beginTransaction().
                replace(R.id.dayschedule_container, newFrag).commit();

        // do something
        Toast.makeText(getActivity(), item.getEventName(), Toast.LENGTH_SHORT).show();
    }



}
