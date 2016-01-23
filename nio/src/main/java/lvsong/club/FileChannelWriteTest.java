package lvsong.club;

import org.springframework.util.ResourceUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by lvsong on 1/20/16.
 */
public class FileChannelWriteTest {
    public static void main(String[] args) {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(
                    ResourceUtils.getFile("classpath:files/writeFile.txt"), "rw");
            FileChannel fileChannel = randomAccessFile.getChannel();

            String newData = "New String to write to file..." + System.currentTimeMillis();

            ByteBuffer byteBuffer = ByteBuffer.allocate(400);

            byteBuffer.clear();
            byteBuffer.put(newData.getBytes());

            byteBuffer.flip();
            while (byteBuffer.hasRemaining()) {
                fileChannel.write(byteBuffer);
            }

            fileChannel.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
