package lvsong.club;

import java.lang.reflect.Method;

/**
 * 检查指定类中是否有定义指定usecase id的注解
 * Created by lvsong on 11/4/15.
 */
public class UseCaseTracker {

    public boolean checkFromId(int id, Class<?> clazz) {
        for(Method method : clazz.getDeclaredMethods()) {
            UseCaseAnnotation useCase = method.getAnnotation(UseCaseAnnotation.class);

            if(useCase != null) {
                System.out.println("Found useCaseAnnotation: " + useCase.id() + " " +
                useCase.descrption());

                if(useCase.id() == id)
                    return true;
            }
        }

        return false;
    }
}
