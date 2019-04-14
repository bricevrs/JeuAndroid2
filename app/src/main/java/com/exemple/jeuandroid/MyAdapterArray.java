package com.exemple.jeuandroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class MyAdapterArray extends ArrayAdapter<Score> {
    private final Context c;

    public MyAdapterArray(Context context, ArrayList<Score> listScore){
        super(context, R.layout.cell_layout, listScore);
        this.c = context;
    }

    public View getView(int pos, View convertView, ViewGroup parent){
        View cellView = convertView;

        if (cellView == null) {
            LayoutInflater inflater = (LayoutInflater) c
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            cellView = inflater.inflate(R.layout.cell_layout, parent, false);
        }

        TextView name = (TextView) cellView.findViewById(R.id.name);
        TextView score = (TextView) cellView.findViewById(R.id.score);

        Score s = getItem(pos);
        name.setText(s.getNom());
        score.setText(s.getScore()+"");

        return cellView;

    }
}
