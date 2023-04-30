package com.rcomputer.genapp.action;
import com.google.gson.Gson; 
import com.google.gson.FieldNamingStrategy; 
import com.google.gson.FieldNamingPolicy; 
import com.google.gson.FieldAttributes; 
import java.lang.reflect.Field; 

public class CustomStrategyCustomer implements FieldNamingStrategy {

    @Override
    public String translateName(Field field) {
        if (field.getName().equals("a0xxukxxbvxxxxxxxxxxcustomer")) {
            return "id";
        }
        if (field.getName().equals("q4xxhxxxbv24xxxxxxxximailaddr")) {
            return "email";
        }
        if (field.getName().equals("c2xxu2fnbvixxxxxxxxxfirstname")) {
            return "first_name";
        }
        if (field.getName().equals("c1xxuslnbvixxxxxxxxxlastname")) {
            return "last_name";
        }
        if (field.getName().equals("z2xxzrqxlexxxxxxxxxxcusttqty")) {
            return "orders_count";
        }
        if (field.getName().equals("z1xxzrpxlexxxxxxxxxxcusttotl")) {
            return "totals_spent";
        }
        if (field.getName().equals("z5xxutlolexxxxxxxxxxlastorder")) {
            return "last_order_id";
        }
        if (field.getName().equals("z1xxztprlxxxxxxxxxxxamounttotal")) {
            return "total_price";
        }
        if (field.getName().equals("yixxuznybvxxxxxxxxxxnotes")) {
            return "note";
        }
        if (field.getName().equals("ydxxuxxybvxxxxxxxxxxcontacted")) {
            return "created_at";
        }
        if (field.getName().equals("zbxxcztxlxxxxxxxxxxxstatusfldt")) {
            return "updated_at";
        }
        //foreign fields like address
        if (field.getName().equals("y4xxudbxbvxxxxxxxxxxmailtocode")) {
            return "addresses";
        }

        // get line_items arrary and populate cuodetails ,extract last item code to save in cuorder
        return field.getName();
    }
}