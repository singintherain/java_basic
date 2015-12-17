package lvsong.club;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

/**
 * Created by lvsong on 11/16/15.
 */
public class HackSystem {
    public final static InputStream is = System.in;
    private static ByteArrayOutputStream buffer = new ByteArrayOutputStream();
    public final static PrintStream out = new PrintStream(buffer);
    public final static PrintStream err = out;

    public static String getBufferString() {
        return buffer.toString();
    }

    public static void clearBuffer() {
        buffer.reset();
    }

    public static void setSecurityManager(final SecurityManager securityManager) {
        System.setSecurityManager(securityManager);
    }

    public static SecurityManager getSecurityManager() {
        return System.getSecurityManager();
    }

    public static long currentTimeMillis() {
        return System.currentTimeMillis();
    }

    public static void arraycopy(Object src, int srcOps, Object dest, int destOps, int length) {
        System.arraycopy(src, srcOps, dest, destOps, length);
    }

    public static int identityHashCode(Object x) {
        return System.identityHashCode(x);
    }
}
