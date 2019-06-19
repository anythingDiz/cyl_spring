package com.cyl.demo.PropertyEditor;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.beans.SimpleBeanInfo;

//负责将属性编辑器和javaBean的属性关联起来
public class ChartBeanBeanInfo extends SimpleBeanInfo {
    @Override
    public PropertyDescriptor[] getPropertyDescriptors() {
        try {
            // titlePropertyEditor 和 ChartBean的titlePosition属性绑定起来
            PropertyDescriptor titlePropertyDescriptor = new PropertyDescriptor("titlePosition",ChartBean.class);
            titlePropertyDescriptor.setPropertyEditorClass(TitlePositionPropertyEditor.class);

            return new PropertyDescriptor[]{titlePropertyDescriptor};
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }

        return super.getPropertyDescriptors();
    }
}
