package annotation;

import java.lang.annotation.*;

/**
 * Created by lvsong on 6/15/15.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Description {
    String value() default "no description";
}
