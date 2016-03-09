package com.commonsware.calendarapp;

import android.content.Context;
import android.text.Layout;
import android.view.View;
import android.view.*;
import android.widget.ImageView;
import android.widget.ArrayAdapter;
import java.util.List;
import android.widget.TextView;
import android.widget.Button;
import android.os.Bundle;
import android.app.Activity;

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