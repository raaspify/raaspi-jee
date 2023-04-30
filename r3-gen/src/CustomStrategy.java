package com.rcomputer.genapp.action;
import com.google.gson.Gson; 
import com.google.gson.FieldNamingStrategy; 
import com.google.gson.FieldNamingPolicy; 
import com.google.gson.FieldAttributes; 
import java.lang.reflect.Field; 

public class CustomStrategy implements FieldNamingStrategy {

/**

*/

    @Override
    //used to map json names to entity names so that json data will move to entity property
    // but raaspi only properties need to be initialized in calling program r3RestClient
    // in shopify there is product (Item category SI-L1 or sub category SI-L*) and product variant (Item detail SI-D) and each product variant has
    // matching Inventory Item  (Item SI-D)
    public String translateName(Field field) {
        //this is for SI-L* , SI-L1 is hard coded, see CustomStrategyVariants for SI-D 
        // does shopify have non shopping type items ?

        if (field.getName().equals("a0xxukixbxxxxxxxxxxxmatcode")) {
            return "id";
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
        if (field.getName().equals("y2xxuxxrbvxxxxxxxxxxmisccode1")) {
            return "product_type";
        }
        if (field.getName().equals("z2xxcsxrlxxxxxxxxxxxdateadded")) {
            return "created_at";
        }
        if (field.getName().equals("z6xxcztxlxxxxxxxxxxxstatusfldt")) {
            return "updated_at";
        }//see CustomStrategyVariants for other fields
        return field.getName();
    }
}