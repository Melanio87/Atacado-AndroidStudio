package com.atacadogames.atacadoinfo.Adapters;


import android.app.Activity;
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

/**
 * @author Melanio
 * Clase Adapter para rellenar el GridView de  la ventana activity_page2 de recomendaciones.
 */
public class AdapterRecomendation extends ArrayAdapter<Integer> {
    //variables para recibir los parametros
    private Context context;
    private int layoutResourceId;
    private ArrayList<Integer> nums;

    public AdapterRecomendation(Context context, int layoutResourceId, ArrayList<Integer> nums){
         super(context, layoutResourceId,nums);
         this.context=context;
         this.layoutResourceId=layoutResourceId;
         this.nums=nums;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        RecordHolder holder = null;

        if (row == null) {
            //Adicionando el diseño personalizado  grid_nums para los cuadros del GridView de activity_page2
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new RecordHolder();
            holder.textDes = (TextView) row.findViewById(R.id.textNumDes);
            holder.textNum = (TextView) row.findViewById(R.id.textNumber);

            row.setTag(holder);
        } else {
            holder = (RecordHolder) row.getTag();
        }

        if(nums != null && !nums.isEmpty()){

            holder.textNum.setText(String.valueOf(nums.get(position)));

            if(nums.get(position) == 0){

                holder.textDes.setText("Nada provável");
            }else{
                if(nums.get(position) == 10){
                    holder.textDes.setText("Extremamente provável");
                }else{
                    holder.textDes.setText("");
                }
            }
        }



        return row;
    }
    //Declarando componentes que seran utilizado en la GridView
    static class RecordHolder {
        TextView textNum;
        TextView textDes;
    }
}
