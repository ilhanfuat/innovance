package com.innovance.common.converter;

import org.apache.commons.beanutils.BeanUtilsBean;
import java.lang.reflect.InvocationTargetException;

public abstract class BasicConverter {
    public static void copyProperties(Object dest, Object src){

        try {
            BeanUtilsBean beanUtilsBean = new BeanUtilsBean();

            beanUtilsBean.copyProperties(dest, src);

        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
