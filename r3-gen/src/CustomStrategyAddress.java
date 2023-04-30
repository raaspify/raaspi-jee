package com.rcomputer.genapp.action;
import com.google.gson.Gson; 
import com.google.gson.FieldNamingStrategy; 
import com.google.gson.FieldNamingPolicy; 
import com.google.gson.FieldAttributes; 
import java.lang.reflect.Field; 

public class CustomStrategyAddress implements FieldNamingStrategy {

    @Override
    public String translateName(Field field) {
        if (field.getName().equals("a0xxukbxbxxxxxxxxxxxaddrescode")) {
            return "id";
        }
        if (field.getName().equals("b1pxusa1bvxxxxxxxxxxaddrl1")) {
            return "address1";
        }
        if (field.getName().equals("b3xxh2acbv11xxxxxxxxcity")) {
            return "city";
        }
        // get line_items arrary and populate cuodetails ,extract last item code to save in cuorder
        return field.getName();
    }
}