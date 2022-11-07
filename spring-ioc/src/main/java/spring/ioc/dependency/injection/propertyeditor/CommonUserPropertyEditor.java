package spring.ioc.dependency.injection.propertyeditor;

import spring.ioc.dependency.injection.constructor.User;

import java.beans.PropertyEditor;
import java.beans.PropertyEditorSupport;

/**
 * @program: algorithmic-total-solution
 * @description:
 * @author: wangzibin
 * @create: 2021-12-08
 **/
public class CommonUserPropertyEditor extends PropertyEditorSupport  {

   /* @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if (text == null || text.indexOf(",") == -1) {
            throw new IllegalArgumentException("设置的字符串格式不正确");
        }
        String[] infos = text.split(",");
        User user = new User(infos[0], Integer.valueOf(infos[1]));
        //2. 调用父类的setValue()方法设置转换后的属性对象
        setValue(user);
    }*/
}

