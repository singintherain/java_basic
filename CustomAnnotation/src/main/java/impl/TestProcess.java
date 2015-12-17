package impl;

import java.lang.annotation.Annotation;

/**
 * Created by lvsong on 6/15/15.
 */
public class TestProcess {
    public static void process(String klass){
        try {
            Class clazz = Class.forName(klass);
            Annotation[] annotations = clazz.getAnnotations();

            for(Annotation annotation : annotations){
                System.out.println(annotation);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
