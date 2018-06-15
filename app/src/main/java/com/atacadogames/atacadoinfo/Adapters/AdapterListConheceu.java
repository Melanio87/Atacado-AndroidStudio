package com.atacadogames.atacadoinfo.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.atacadogames.atacadoinfo.R;

import java.util.ArrayList;
import java.util.List;

public class AdapterListConheceu extends ArrayAdapter<String> {
    Context context;
    ArrayList<String> values;

    public AdapterListConheceu(Context context, ArrayList<String> values){
        super(context, R.layout.row_medios,values);
        this.context=context;
        this.values=values;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.row_medios, parent, false);

        TextView textView = (TextView) rowView.findViewById(R.id.descri);

        textView.setText(values.get(position));


        return rowView;
    }
}
