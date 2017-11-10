package com.example.iraisyishar.transporta2;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by iraisyishar on 10/11/2017.
 */

public class ItemRutaAdapter extends BaseAdapter {
    protected Activity activity;
    protected ArrayList<Ruta> items;

    public ItemRutaAdapter(Activity activity, ArrayList<Ruta> items) {
        this.activity = activity;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return items.get(i).getId();
    }

    @Override
    public View getView(int position, View contentView, ViewGroup parent) {
        View vi=contentView;

        if(contentView == null) {
            LayoutInflater inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            vi = inflater.inflate(R.layout.item_lista_rutas, null);
        }

        Ruta item = items.get(position);


        TextView numRuta = (TextView) vi.findViewById(R.id.tvNumRuta);
        numRuta.setText(item.getNumRuta());

        TextView origen = (TextView) vi.findViewById(R.id.tvOrigen);
        origen.setText("Origen: "+ item.getOrigen());

        TextView destino = (TextView) vi.findViewById(R.id.tvDestino);
        destino.setText("Destino: "+ item.getDestino());

        return vi;
    }
}
