package com.cyl.demo.PropertyEditor;

import java.beans.PropertyEditorSupport;

/**
 * @Description titlePosition属性的 属性编辑器
 * @Author dianXiao2
 * @Version V1.0.0
 * @Date 2019/6/19
 */
public class TitlePositionPropertyEditor extends PropertyEditorSupport {

    private String[] options = {"left", "center", "right"};

    //代表可选属性的字符串数组表示
    @Override
    public String[] getTags() {
        return options;
    }

    //属性初始值的字符串
    @Override
    public String getJavaInitializationString() {
        return ""+getValue();
    }

    //将内部属性值转为对应的字符串表示形式
    @Override
    public String getAsText() {
        int value = (Integer) getValue();
        return options[value];
    }

    //将外部设置的字符串转坏为内部设置
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        for(int i = 0; i < options.length; i++){
            if(options[i].equals(text)){
                setValue(i);
                return;
            }
        }
    }
}
