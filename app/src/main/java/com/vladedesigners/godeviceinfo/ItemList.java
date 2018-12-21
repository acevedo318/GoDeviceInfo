package com.vladedesigners.godeviceinfo;

import com.jjoe64.graphview.GraphView;

/**
 * Created by Kevin A. Acevedo on 21/12/2018.
 */
public class ItemList {

    private String property;
    private String value;
    private GraphView graph;

    public ItemList(String property,String value){

        this.property = property;
        this.value = value;

    }

    public ItemList(String property){

        this.property = property;

    }

    public ItemList(GraphView graph){

        this.graph = graph;

    }

    public ItemList(){

    }

    public String getProperty() {
        return property;
    }

    public String getValue() {
        return value;
    }

    public GraphView getGraph() {
        return graph;
    }
}
