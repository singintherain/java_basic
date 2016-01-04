package lvsong.club.introspector;

import lvsong.club.jdk.Student;
import lvsong.club.jdk.StudentNamePropertyEditor;
import lvsong.club.jdk.StudentSexPropertyEditor;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.PropertyEditorRegistrySupport;
import org.springframework.beans.propertyeditors.StringArrayPropertyEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;

import java.beans.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * Created by lvsong on 1/3/16.
 */
public class IntrospectorTest {
    private BeanInfo beanInfo;

    @Before
    public void startUp() throws IntrospectionException {
//        设置Student类的BeanInfo的sex属性编辑器
        beanInfo = Introspector.getBeanInfo(Student.class);

        for(PropertyDescriptor propertyDescriptor : beanInfo.getPropertyDescriptors()) {
            if(propertyDescriptor.getName().equals("sex")) {
                propertyDescriptor.setPropertyEditorClass(StudentSexPropertyEditor.class);
            } else if(propertyDescriptor.getName().equals("name")) {
//                propertyDescriptor.setPropertyEditorClass(StringTrimmerEditor.class);
                propertyDescriptor.setPropertyEditorClass(StudentNamePropertyEditor.class);
            }
        }
    }

    @Test
    public void beanInfoTest() throws IntrospectionException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Properties properties = new Properties();
        properties.setProperty("name", "zhangsan");
        properties.setProperty("sex", "female");

        Student student = new Student();

        for(String key : properties.stringPropertyNames()) {
            for(PropertyDescriptor propertyDescriptor : beanInfo.getPropertyDescriptors()) {
                if(propertyDescriptor.getName().equals(key)) {
                    Class propertyType = propertyDescriptor.getPropertyType();

                    Method writeMethod = propertyDescriptor.getWriteMethod();
                    Class propertyEditorClass = propertyDescriptor.getPropertyEditorClass();
                    PropertyEditor propertyEditor = (PropertyEditor)propertyEditorClass.
                            getConstructor().newInstance();
                    propertyEditor.setAsText(properties.getProperty(key));

                    writeMethod.invoke(student, propertyType.cast(propertyEditor.getValue()));
                }
            }
        }

        System.out.println(student);
    }
}
