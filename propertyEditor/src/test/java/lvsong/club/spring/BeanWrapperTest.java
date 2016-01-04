package lvsong.club.spring;

import lvsong.club.jdk.Sex;
import lvsong.club.jdk.Student;
import lvsong.club.jdk.StudentSexPropertyEditor;
import org.junit.Test;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

/**
 * Created by lvsong on 1/3/16.
 */
public class BeanWrapperTest {
    @Test
    public void iocTest() {
        BeanWrapper studentBeanWrapper = new BeanWrapperImpl(new Student());
        studentBeanWrapper.setPropertyValue("name", "zhangsan");

//        只需要注册sex属性的编辑器就可以了，name属性不需要
//                name属性本身就是String类型，但是找不到默认的String类型的属性编辑器
//        不知道BeanWrapper对String类型的数据是怎么处理的，可以追踪下源码
        studentBeanWrapper.registerCustomEditor(Sex.class, new StudentSexPropertyEditor());

        studentBeanWrapper.setPropertyValue("sex", "female");

        Student student = (Student) studentBeanWrapper.getWrappedInstance();

        System.out.println(student);
    }
}
