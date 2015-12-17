package lvsong.club;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by lvsong on 11/5/15.
 */
@Target(ElementType.TYPE) //只能作用于类
@Retention(RetentionPolicy.RUNTIME)
public @interface DBTable {
    public String name() default ""; // 数据库表名
}
