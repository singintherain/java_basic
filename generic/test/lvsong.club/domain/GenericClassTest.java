package lvsong.club.domain;

import lvsong.club.Apple;
import lvsong.club.GenericClass;
import lvsong.club.Orange;
import org.junit.Test;

/**
 * Created by lvsong on 11/4/15.
 */
public class GenericClassTest {
    @Test
    public void instanceTest() {
        GenericClass<Apple> apples = new GenericClass<Apple>(new Apple());
        System.out.println(apples.getObject());

//        GenericClass<Orange> oranges = new GenericClass<Orange>(new Apple());
    }
}
