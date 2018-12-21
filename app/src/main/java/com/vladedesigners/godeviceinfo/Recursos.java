package com.vladedesigners.godeviceinfo;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;

import java.lang.reflect.Field;

public class Recursos {

    Context context;

    public Recursos(Context context){
        this.context = context;
    }


    public String getString(int codRecurso){

        Resources res = context.getResources();

        return res.getString(codRecurso);
    }

    public String AndroidOSName(){

        int code = Build.VERSION.SDK_INT;
        String name;

        if(code == 9 || code == 10){
            name = "Gingerbread";
        }else if(code <= 13){
            name = "Honeycomb";
        }else if(code <= 15){
            name = "Ice Cream Sandwich";
        }else if(code <= 18){
            name = "Jelly Bean";
        }else if(code <= 20){
            name = "KitKat";
        }else if(code <= 22){
            name = "Lollipop";
        }else if(code <= 23){
            name = "Marshmallow";
        }else if(code <= 25){
            name = "Nougat";
        }else if(code <= 27){
            name = "Oreo";
        }else if(code <= 28){
            name = "Pie";
        }else {
            name =  getString(R.string.Desconocido);
        }



        return name;
    }

}
