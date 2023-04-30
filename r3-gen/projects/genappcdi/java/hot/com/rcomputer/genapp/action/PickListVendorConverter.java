package com.rcomputer.genapp.action;
import com.rcomputer.genapp.model.*;
import org.primefaces.component.picklist.PickList;
import org.primefaces.model.DualListModel;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "vEntityConverter")
public class PickListVendorConverter implements Converter {
    @Override
    public Object getAsObject(FacesContext fc, UIComponent comp, String value) {
        DualListModel<Jxxxuq300xwwqqhxxxxxvendor> model = (DualListModel<Jxxxuq300xwwqqhxxxxxvendor>) ((PickList) comp).getValue();
        for (Jxxxuq300xwwqqhxxxxxvendor entity : model.getSource()) {
            if (entity.getA0xxukxxbvxxxxxxxxxxvendor().equals(value)) {
                return entity;
            }
        }
        for (Jxxxuq300xwwqqhxxxxxvendor entity : model.getTarget()) {
            if (entity.getA0xxukxxbvxxxxxxxxxxvendor().equals(value)) {
                return entity;
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent comp, Object value) {
        return ((Jxxxuq300xwwqqhxxxxxvendor) value).getA0xxukxxbvxxxxxxxxxxvendor();
    }
}

