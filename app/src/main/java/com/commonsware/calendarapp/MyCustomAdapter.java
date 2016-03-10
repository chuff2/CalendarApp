package com.commonsware.calendarapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by connerhuff on 3/8/16.
 */
public class MyCustomAdapter extends ArrayAdapter<ScheduleEvent> {


    Context context;

    public MyCustomAdapter(Context context, List<ScheduleEvent> items) {
        super(context, R.layout.fragment_dayschedule, items);
        this.context = context;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null) {
            // inflate the GridView item layout
            //LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.listcell, parent, false);

            // initialize the view holder
            viewHolder = new ViewHolder();
            viewHolder.deleteButton = (Button) convertView.findViewById(R.id.deleteButton);
            viewHolder.eventName = (TextView) convertView.findViewById(R.id.eventName);
            viewHolder.startTime = (TextView) convertView.findViewById(R.id.startTime);
            viewHolder.endTime = (TextView) convertView.findViewById(R.id.endTime);

            convertView.setTag(viewHolder);
        } else {
            // recycle the already inflated view
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //return false;
                // retrieve theListView item
                String name = ((TextView)((RelativeLayout)((LinearLayout) v.getParent())
                        .getChildAt(0)).getChildAt(0)).getText().toString();
                String date = MainActivity.currentDate;
                //Toast.makeText(context, name + date, Toast.LENGTH_SHORT).show();
                MainActivity.mydb.deleteEvent(name, date);

                DayScheduleFragment newFrag = new DayScheduleFragment();
                MainActivity.f.beginTransaction().
                        replace(R.id.dayschedule_container, newFrag).commit();
                /*
                ScheduleEvent item = events.get(position);

                events.remove(position);
                ((MainActivity) getActivity()).getMydb().deleteEvent(item.getId());


                DayScheduleFragment newFrag = new DayScheduleFragment();
                getFragmentManager().beginTransaction().
                        replace(R.id.dayschedule_container, newFrag).commit();
                */
            }
        });

        // update the item view
        ScheduleEvent item = getItem(position);
        if (item.getEventName().length() >= 20){
            viewHolder.eventName.setText(item.getEventName().substring(0,20) + "...");
        }
        else{
            viewHolder.eventName.setText(item.getEventName());
        }
        viewHolder.startTime.setText(item.getStartTime());
        viewHolder.endTime.setText(item.getEndTime());
        return convertView;
    }

    /**
     * The view holder design pattern prevents using findViewById()
     * repeatedly in the getView() method of the adapter.
     *
     * @see http://developer.android.com/training/improving-layouts/smooth-scrolling.html#ViewHolder
     */
    private static class ViewHolder {
        Button deleteButton;
        TextView eventName;
        TextView startTime;
        TextView endTime;
    }
}