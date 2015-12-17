package annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by lvsong on 6/15/15.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Test {
    String isAop() default "false";
}
