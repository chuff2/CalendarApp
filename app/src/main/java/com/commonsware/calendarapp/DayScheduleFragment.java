package com.commonsware.calendarapp;

import android.app.Fragment;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Toast;
import android.content.Context;
import java.util.ArrayList;

import java.util.List;

/**
 * Created by connerhuff on 3/8/16.
 */
public class DayScheduleFragment extends ListFragment {

    private List<ScheduleEvent> schedList;
    private String data;
    private static final String[] items = {"Conner", "Austin", "Huff"};

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
        setListAdapter(new IconicAdapter());
        Toast.makeText(getActivity(), data, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //getListView().setOnItemClickListener(this);
    }




    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setListAdapter(new MyCustomAdapter());
    }

    public class MyCustomAdapter extends ArrayAdapter<String> {
        public MyCustomAdapter(Context context, int resource, int textViewResourceId, String[] dayOfWeek) {
            super(context, resource, textViewResourceId, dayOfWeek);
        }

        @Override
        public View getView(int position, View convertView,
                            ViewGroup parent) {
            /*
            View row=super.getView(position, convertView, parent);
            ImageView icon=(ImageView)row.findViewById(R.id.icon);
            if (items[position].length()>4) {
                icon.setImageResource(R.drawable.delete);
            }
            else {
                icon.setImageResource(R.drawable.ok);
            }
            TextView size=(TextView)row.findViewById(R.id.size);
            size.setText(String.format(getString(R.string.size_template),
                    items[position].length()));
            return(row);
            */
            return null;
        }
    }


}
