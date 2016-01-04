package lvsong.club.jdk;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.beans.SimpleBeanInfo;

/**
 * Created by lvsong on 1/3/16.
 */
public class StudentBeanInfo extends SimpleBeanInfo {
    @Override
    public PropertyDescriptor[] getPropertyDescriptors() {
        try {
            PropertyDescriptor sexPropertyDescriptor = new PropertyDescriptor(
                    "sex",
                    Student.class
            );
            sexPropertyDescriptor.setPropertyEditorClass(StudentSexPropertyEditor.class);

            PropertyDescriptor namePropertyDescriptor = new PropertyDescriptor(
                    "name",
                    Student.class
            );
            namePropertyDescriptor.setPropertyEditorClass(StudentNamePropertyEditor.class);

            return new PropertyDescriptor[] {sexPropertyDescriptor, namePropertyDescriptor};

        } catch (IntrospectionException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
