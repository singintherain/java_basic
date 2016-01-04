package lvsong.club.jdk;

import org.junit.Test;

import java.beans.PropertyDescriptor;
import java.beans.PropertyEditor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * Created by lvsong on 1/3/16.
 */
public class StudentBeanPropertyEditorTest {
    @Test
    public void StringTest() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Properties properties = new Properties();
        properties.setProperty("name", "zhangsan");
        properties.setProperty("sex", "female");

        Student student = new Student();

        StudentBeanInfo studentBeanInfo = new StudentBeanInfo();

        for(String property : properties.stringPropertyNames()) {
            for(PropertyDescriptor propertyDescriptor : studentBeanInfo.getPropertyDescriptors()) {
                if(propertyDescriptor.getName().equals(property)) {
                    Class propertyType = propertyDescriptor.getPropertyType();

                    Method writeMethod = propertyDescriptor.getWriteMethod();
                    Class propertyEditorClass = propertyDescriptor.getPropertyEditorClass();
                    PropertyEditor propertyEditor = (PropertyEditor)propertyEditorClass.
                            getConstructor().newInstance();
                    propertyEditor.setAsText(properties.getProperty(property));

                    writeMethod.invoke(student, propertyType.cast(propertyEditor.getValue()));
                }
            }

        }

        System.out.println(student);
    }
}
