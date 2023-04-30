package com.rcomputer.genapp.action;
import com.google.gson.Gson; 
import com.google.gson.FieldNamingStrategy; 
import com.google.gson.FieldNamingPolicy; 
import com.google.gson.FieldAttributes; 
import java.lang.reflect.Field; 

public class CustomStrategyOrder implements FieldNamingStrategy {

    @Override
    public String translateName(Field field) {
        if (field.getName().equals("a0xxuncobvxxxxxxxxxxpurchsno")) {
            return "order_number";
        }
        if (field.getName().equals("z1xxztprlxxxxxxxxxxxamounttotal")) {
            return "total_price";
        }
        if (field.getName().equals("yexxuznybvxxxxxxxxxxnotes")) {
            return "note";
        }
        if (field.getName().equals("c1xxcxxxbxxxxxxxxxxxodatet")) {
            return "created_at";
        }
        if (field.getName().equals("zdxxcztxlxxxxxxxxxxxstatusfldt")) {
            return "updated_at";
        }
        if (field.getName().equals("jxxxuq201xwwqqhxxxxxcustomer")) {
            return "customer";
        }
        if (field.getName().equals("a0xxukxxbvxxxxxxxxxxcustomer")) {
            return "id";
        }

        if (field.getName().equals("xoxxuq2b4xwwqqhxxxxxcuodetails")) {
            return "line_items";
        }

        if (field.getName().equals("a0xxucdxbvxxxxxxxxxxcuono")) {
            return "order_number";
        }

        if (field.getName().equals("z5xxzpxravxxxxxxxxxxordprice")) {
            return "price";
        }

        if (field.getName().equals("z2xxudiravxxxxxxxxxxmatcode")) {
            return "product_id";
        }

        // get line_items arrary and populate cuodetails ,extract last item code to save in cuorder
        return field.getName();
    }
}