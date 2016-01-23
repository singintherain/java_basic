package lvsong.club;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

/**
 * Created by lvsong on 1/14/16.
 */
public class SocketChannelExample {
    public static void main(String[] args) {
        int port = 4444;
        try {
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);
            socketChannel.connect(new InetSocketAddress("localhost", port));

            while (!socketChannel.finishConnect()) {
                System.out.println("still connecting");
            }
//            while (true) {
                ByteBuffer byteBuffer = ByteBuffer.allocate(1024 * 1024);
                int count = 0;
                String message = "";
//                while ((count = socketChannel.read(byteBuffer)) > 0) {
//                    byteBuffer.flip();
//                    message += Charset.defaultCharset().decode(byteBuffer);
//                }
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

                String s;

                while((s = bufferedReader.readLine()) != null && s.length() != 0) {
                    byteBuffer.put(s.getBytes());
                    byteBuffer.flip();          // 必须要有
                    socketChannel.write(byteBuffer);
                    byteBuffer.clear();
//                    socketChannel.write(byteBuffer);
                }

//                System.out.print("bufferedReader: " + bufferedReader);

//                byteBuffer.put()

//                socketChannel.write(byteBuffer);

//                if(message.length() > 0) {
////                    System.out.println(message);
//                    CharBuffer buffer = CharBuffer.wrap("Hello Server");
//                    while (buffer.hasRemaining()) {
//                        socketChannel.write(Charset.defaultCharset().encode(buffer));
//                    }
//                    message = "";
//                }
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
