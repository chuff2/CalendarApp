package com.commonsware.calendarapp;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by connerhuff on 3/8/16.
 */
public class DayScheduleFragment extends Fragment {

    private List<ScheduleEvent> schedList;
    private String data;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (getArguments() != null)
            data = getArguments().getString("date");

        return inflater.inflate(R.layout.fragment_dayschedule, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        Toast.makeText(getActivity(), data, Toast.LENGTH_LONG).show();


    }



}
