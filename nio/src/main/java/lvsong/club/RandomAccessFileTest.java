package lvsong.club;

import org.springframework.util.ResourceUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 * Created by lvsong on 1/17/16.
 */
public class RandomAccessFileTest {
    public static void main(String[] args) {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(
                    ResourceUtils.getFile("classpath:files/randomAccessFile.txt"), "rw");
            FileChannel inChannel = randomAccessFile.getChannel();

            ByteBuffer buffer = ByteBuffer.allocate(48);

            int bytesRead = inChannel.read(buffer);

            while(bytesRead != -1) {
                System.out.println("Read " + bytesRead);
                buffer.flip();

                while(buffer.hasRemaining()) {
                    System.out.println("remaining");
                    CharBuffer charBuffer = Charset.forName("UTF-8").decode(buffer);
                    System.out.println(charBuffer);
                }

                buffer.clear();
                bytesRead = inChannel.read(buffer);
            }

            randomAccessFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
