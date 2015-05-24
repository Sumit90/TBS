package com.project.tbs.tbs;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by home on 24-05-2015.
 */
public class MyArrayAdapter extends ArrayAdapter<ColourPOJO> {

    private final Context context;
    private final List<ColourPOJO> values;

    public MyArrayAdapter(Context context, List<ColourPOJO> values) {
        super(context, -1, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.adapter_layout, parent, false);
        TextView textViewFirst = (TextView) rowView.findViewById(R.id.firstLine);
        TextView textViewSecond = (TextView) rowView.findViewById(R.id.secondLine);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);

        ColourPOJO colourPOJO= values.get(position);

        textViewFirst.setText(colourPOJO.getColourName());
        textViewSecond.setText(colourPOJO.getColourCode());
        Log.v("------------------colour------------------",colourPOJO.getColourHex());
        imageView.setBackgroundColor(Color.parseColor(colourPOJO.getColourHex()));


        return rowView;
    }

}
