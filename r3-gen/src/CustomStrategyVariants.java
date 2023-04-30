package com.rcomputer.genapp.action;
import com.google.gson.Gson; 
import com.google.gson.FieldNamingStrategy; 
import com.google.gson.FieldNamingPolicy; 
import com.google.gson.FieldAttributes; 
import java.lang.reflect.Field; 

public class CustomStrategyVariants implements FieldNamingStrategy {

    @Override
    public String translateName(Field field) {
        // not used because alternative method of reading variants array is used in r3restclient
        //this is for SI-D, see CustomStrategy for SI-L* or SI-L1
        // does shopify have non shopping type items ?
        if (field.getName().equals("b8fbzpxxbvxxxxxxxxxxselprice")) {
            return "price";
        }//
        if (field.getName().equals("b0xxziqxlvxxsaxxxxxxquantity")) {
            return "inventory_quantity";
        }//
        if (field.getName().equals("f1xxuxxrbvxxxxxxxxxxaliascode")) {
            return "sku";
        }//
        if (field.getName().equals("zxxrbvxxxvxxxxxxxxxxbarupc")) {
            return "barcode";
        }

        if (field.getName().equals("a0xxukixbxxxxxxxxxxxmatcode")) {
            return "id";
        }

        if (field.getName().equals("f2xxuxxrbvxxxxxxxxxxparentcode")) {
            return "product_id";//use keytoEntity to get sid
        }

        if (field.getName().equals("b1xxuszsbvxxxxxxxxxxdescript")) {
            return "title";
        }
        if (field.getName().equals("w7xxuznxbvxxxxxxxxxxnotes")) {
            return "body_html";
        }
        if (field.getName().equals("b3xxuxxrbvxxxxxxxxxxsource1")) {
            return "vendor";
        }
        if (field.getName().equals("c6xxusxrbv16xxxxxxxxtype")) {
            return "product_type";
        }
        if (field.getName().equals("z2xxcsxrlxxxxxxxxxxxdateadded")) {
            return "created_at";
        }
        if (field.getName().equals("z6xxcztxlxxxxxxxxxxxstatusfldt")) {
            return "updated_at";
        }



        return field.getName();
    }
}