package com.rcomputer.genapp.action;
import com.rcomputer.genapp.model.*;
import org.primefaces.component.picklist.PickList;
import org.primefaces.model.DualListModel;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "eEntityConverter")
public class PickListEmployeeConverter implements Converter {
    @Override
    public Object getAsObject(FacesContext fc, UIComponent comp, String value) {
        DualListModel<Jxxxbh400xwwqqhxxxxxemployee> model = (DualListModel<Jxxxbh400xwwqqhxxxxxemployee>) ((PickList) comp).getValue();
        for (Jxxxbh400xwwqqhxxxxxemployee entity : model.getSource()) {
            if (entity.getA0xxuktxbvxxxxxxxxxxemployee().equals(value)) {
                return entity;
            }
        }
        for (Jxxxbh400xwwqqhxxxxxemployee entity : model.getTarget()) {
            if (entity.getA0xxuktxbvxxxxxxxxxxemployee().equals(value)) {
                return entity;
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent comp, Object value) {
        return ((Jxxxbh400xwwqqhxxxxxemployee) value).getA0xxuktxbvxxxxxxxxxxemployee();
    }
}

