package com.vladedesigners.godeviceinfo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.List;

/**
 * Created by Kevin A. Acevedo on 21/12/2018.
 */
public class Adaptador extends BaseAdapter {

    Context context;
    List<ItemList> itemLists;
    public GraphView graphView;


    public Adaptador(Context context, List<ItemList> itemLists) {
        this.context = context;
        this.itemLists = itemLists;
    }

    @Override
    public int getCount() {
        return itemLists.size();
    }

    @Override
    public Object getItem(int i) {
        return itemLists.get(i);
    }

    @Override
    public long getItemId(int i) {
        return itemLists.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View vista = view;
        LayoutInflater layoutInflater = LayoutInflater.from(this.context);

        vista = layoutInflater.inflate(R.layout.itemlistview,null);

        GraphView graphView = (GraphView) vista.findViewById(R.id.graph);
        TextView textProperty = (TextView) vista.findViewById(R.id.textViewProperty);
        TextView textValue = (TextView) vista.findViewById(R.id.textViewValue);

        ItemList elemento = itemLists.get(i);

        if(elemento.getProperty() == null || elemento.getProperty().isEmpty()){
            textProperty.setVisibility(View.GONE);
            textProperty.setText(elemento.getProperty());
            graphView.setVisibility(View.VISIBLE);
        }else{
            textProperty.setText(elemento.getProperty());
        }

        if(elemento.getValue() == null || elemento.getValue().isEmpty()){
            textValue.setVisibility(View.GONE);
            textProperty.setTextSize(20f);
        }else{
            textValue.setText(elemento.getValue());
        }


        if(!(elemento.getGraph() == null)){

            elemento.setGraph(graphView);

            graphView = graphView;

            graphView.getViewport().setScalable(true);

        }


        return vista;
    }


}
