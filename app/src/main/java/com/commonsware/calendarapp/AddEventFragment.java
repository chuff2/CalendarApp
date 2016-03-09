package com.commonsware.calendarapp;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by connerhuff on 3/9/16.
 */
public class AddEventFragment extends Fragment {

    EditText eName;
    EditText sTime;
    EditText eTime;
    Button button;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_addevent, container, false);
        eName = (EditText) v.findViewById(R.id.newEventName);
        sTime = (EditText) v.findViewById(R.id.newStartTime);
        eTime = (EditText) v.findViewById(R.id.newEndTime);
        button = (Button) v.findViewById(R.id.saveButton);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                ScheduleEvent newSEvent = new ScheduleEvent(eName.getText().toString(),
                        sTime.getText().toString(), eTime.getText().toString());
                ((MainActivity) getActivity()).setNewEvent(newSEvent);
                //bring back the event list fragment
                DayScheduleFragment newFrag = new DayScheduleFragment();
                Bundle args = new Bundle();
                args.putString("date", ((MainActivity) getActivity()).getCurrentDate());
                newFrag.setArguments(args);

                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.dayschedule_container, newFrag)
                        .addToBackStack(null)
                        .commit();
            }
        });

        return v;
    }

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
    }


}
