package com.rcomputer.genapp.action;
import com.rcomputer.genapp.model.*;
import org.primefaces.component.picklist.PickList;
import org.primefaces.model.DualListModel;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "cEntityConverter")
public class PickListCustomerConverter implements Converter {
    @Override
    public Object getAsObject(FacesContext fc, UIComponent comp, String value) {
        DualListModel<Jxxxuq201xwwqqhxxxxxcustomer> model = (DualListModel<Jxxxuq201xwwqqhxxxxxcustomer>) ((PickList) comp).getValue();
        for (Jxxxuq201xwwqqhxxxxxcustomer entity : model.getSource()) {
            if (entity.getA0xxukxxbvxxxxxxxxxxcustomer().equals(value)) {
                return entity;
            }
        }
        for (Jxxxuq201xwwqqhxxxxxcustomer entity : model.getTarget()) {
            if (entity.getA0xxukxxbvxxxxxxxxxxcustomer().equals(value)) {
                return entity;
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent comp, Object value) {
        return ((Jxxxuq201xwwqqhxxxxxcustomer) value).getA0xxukxxbvxxxxxxxxxxcustomer();
    }
}

