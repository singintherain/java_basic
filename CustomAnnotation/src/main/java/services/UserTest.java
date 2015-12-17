package services;

import annotation.Description;
import annotation.Name;
import annotation.Test;
import impl.TestProcess;
import sun.security.krb5.internal.crypto.Des;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by lvsong on 6/15/15.
 */
@Test(isAop = "true")
public class UserTest {
    public static void main(String[] args){

//        TestProcess.process("services.UserTest");
        final String CLASS_NAME = "services.Master";
        try {
            Class test = Class.forName(CLASS_NAME);
            System.out.println(test.getName());
            Method[] methods = test.getMethods();
            boolean flag = test.isAnnotationPresent(Description.class);

            if(flag){
                Description desc = (Description)test.getAnnotation(Description.class);
                System.out.println("描述：" + desc.value());
                System.out.println("--------------");
            }

            Set<Method> set = new HashSet<Method>();

            for(Method method : methods){
                boolean otherFlag = method.isAnnotationPresent(Name.class);

                if(otherFlag){
                    set.add(method);
                }
            }

            for(Method method : set){
                Name name = method.getAnnotation(Name.class);
                System.out.println(name.originate());
                System.out.println(name.community());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
