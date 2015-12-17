package lvsong.club;

import java.lang.reflect.Method;

/**
 * Created by lvsong on 11/16/15.
 */
public class JavaClassExecutor {
    public static String execute(byte[] classByte) {
        HackSystem.clearBuffer();
        ClassModifier classModifier = new ClassModifier(classByte);
        byte[] modiBytes = classModifier.modifyUTF8Constant(
                "java/lang/System",
                "lvsong.club.HackSystem"
        );
        HotSwapClassLoader hotSwapClassLoader = new HotSwapClassLoader();
        Class clazz = hotSwapClassLoader.loadByte(classByte);

        try {
            Method method = clazz.getMethod("main", new Class[]{String[].class});
            method.invoke(null, new String[]{null});
        } catch (Throwable e) {
            e.printStackTrace(HackSystem.out);
        }

        return HackSystem.getBufferString();
    }
}
