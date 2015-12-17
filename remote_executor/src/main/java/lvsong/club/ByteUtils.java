package lvsong.club;

/**
 * 字节数组处理工作
 * Created by lvsong on 11/16/15.
 */
public class ByteUtils {
    public static int bytes2Int(byte[] b, int start, int len) {
        int sum = 0;
        int end =  start + len;

        for(int i = start; i < end; i++) {
            int n = ((int)b[i]) & 0xff;

            n <<= (--len) * 8;

            sum += n;
        }

        return sum;
    }

    public static byte[] int2Bytes(int value, int len) {
        byte[] b = new byte[len];

        for(int i = 0; i < len; i++) {
            b[len-i-1] = (byte)((value >> 8*i) & 0xff);
        }

        return b;
    }

    public static byte[] bytesReplace(byte[] originBytes, int offset, int len, byte[] replaceBytes) {
        byte[] newByte = new byte[originBytes.length + replaceBytes.length - len];

        System.arraycopy(originBytes, 0, newByte, 0, offset);
        System.arraycopy(replaceBytes, 0, newByte, offset, replaceBytes.length);
        System.arraycopy(originBytes, offset + len, newByte, offset+replaceBytes.length, originBytes.length-offset-len);

        return newByte;
    }

    public static byte[] string2Bytes(String str) {
        return str.getBytes();
    }

    public static String bytes2String(byte[] b, int start, int len) {
        return new String(b, start, len);
    }
}
