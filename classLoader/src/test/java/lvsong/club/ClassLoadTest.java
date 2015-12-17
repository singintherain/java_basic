package lvsong.club;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by lvsong on 11/7/15.
 */
public class ClassLoadTest {

    @Test
    public void classLoaderTest() throws Exception {
        ClassLoader classLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";

                InputStream inputStream = getClass().getResourceAsStream(fileName);

                if(inputStream == null) {
                    return super.loadClass(name);
                }

                try {
                    byte[] b = new byte[inputStream.available()];
                    inputStream.read(b);

                    return defineClass(name, b, 0, b.length);
                } catch (IOException e) {
                    throw new ClassNotFoundException(name);
                }
            }
        };

        Object object = classLoader.loadClass("lvsong.club.StudentBean").newInstance();

        System.out.println(object.getClass());

        Assert.assertFalse(object instanceof lvsong.club.StudentBean);
    }
}
