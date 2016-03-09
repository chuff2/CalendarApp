package com.commonsware.calendarapp;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by connerhuff on 3/9/16.
 */
public class AddEventFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_addevent, container, false);
    }

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);


        Button button = (Button) getActivity().findViewById(R.id.saveButton);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                
            }
        });
    }
}
