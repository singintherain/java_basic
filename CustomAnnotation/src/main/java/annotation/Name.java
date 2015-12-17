package annotation;

import java.lang.annotation.*;

/**
 * Created by lvsong on 6/15/15.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Name {
    String originate();
    String community();
}
