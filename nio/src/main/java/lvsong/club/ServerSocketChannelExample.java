package lvsong.club;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by lvsong on 1/13/16.
 */
public class ServerSocketChannelExample {
    private static String clientChannel = "clientChannel";
    private static String serverChannel = "serverChannel";
    private static String channelType = "channelType";

    public static void main(String[] args) {
        int port = 4444;
//        String localhost = "127.0.0.1";
        String localhost = "0.0.0.0";

        try {
            ServerSocketChannel channel = ServerSocketChannel.open();
            channel.bind(new InetSocketAddress(localhost, port));
            channel.configureBlocking(false);
            Selector selector = Selector.open();
            SelectionKey socketServerSelectionKey = channel.register(selector, SelectionKey.OP_ACCEPT);

            Map<String, String> properties = new HashMap<String, String>();
            properties.put(channelType, serverChannel);
            socketServerSelectionKey.attach(properties);

            for(;;) {
                System.out.println("selector 处于阻塞状态，等待客户端连接");
                if(selector.select() == 0) {
                    System.out.println("selector 连接错误, 重新等待客户端连接");
                    continue;
                }
                System.out.println("selector 获得客户端连接请求响应");
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> selectionKeyIterator = selectionKeys.iterator();
                System.out.println("待处理socket事件个数：" + selectionKeys.size());
                while (selectionKeyIterator.hasNext()) {
                    SelectionKey key = selectionKeyIterator.next();

                    System.out.println("待处理selection key：" + key);
                    if(((Map<?, ?>)key.attachment()).get(channelType).equals(serverChannel)) {
                        ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
                        System.out.println("before accept, 尝试建立与客户端连接的socket");
                        SocketChannel clientSocketChannel = serverSocketChannel.accept();
                        System.out.println("after accept, 完成建立与客户端连接的socket: " +
                                clientSocketChannel.getRemoteAddress());
                        System.out.println("localPort " +
                        clientSocketChannel.socket().getPort());

                        if(clientSocketChannel != null) {
                            clientSocketChannel.configureBlocking(false);
                            SelectionKey clientKey  = clientSocketChannel.register(
                                    selector,
                                    SelectionKey.OP_READ,
                                    SelectionKey.OP_WRITE
                            );
                            Map<String, String> clientProperties = new HashMap<String, String>();
                            clientProperties.put(channelType, clientChannel);
                            clientKey.attach(clientProperties);

                            CharBuffer buffer = CharBuffer.wrap("Hello client");
                            while (buffer.hasRemaining()) {
                                clientSocketChannel.write(Charset.defaultCharset().encode(buffer));
                            }
                            buffer.clear();
                        }
                    } else {
                        System.out.println("客户端开始通信");
                        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
//                        ByteBuffer byteBuffer = ByteBuffer.allocate(1024 * 1024);
                        SocketChannel clientChannel = (SocketChannel) key.channel();
                        int bytesRead = 0;
                        if(key.isReadable()) {
                            /**
                             * 长连接
                             */
//                            bytesRead = clientChannel.read(byteBuffer);
//
//                            // 判断是否是客户端断开了连接
//                            if((bytesRead <= 0)) {
//                                System.out.println("客户端断开连接");
//                                clientChannel.close();
//                            } else {
//                                do {
//                                    byteBuffer.flip();
//                                    System.out.println("接受客户端数据大小" + bytesRead);
//                                    System.out.println("客户端: " + Charset.defaultCharset().decode(byteBuffer));
//                                    System.out.println("打开的通信socket: " + clientChannel.socket());
//                                    System.out.println("打开的通信socket对象: " + clientChannel.hashCode());
//                                    byteBuffer.clear();
//                                } while ((bytesRead = clientChannel.read(byteBuffer)) > 0);
//                            }

                            /**
                             * 短链接
                             */
                            while ((bytesRead = clientChannel.read(byteBuffer)) > 0) {

                                byteBuffer.flip();
                                System.out.println("接受客户端数据大小" + bytesRead);
                                System.out.println("客户端: " + Charset.defaultCharset().decode(byteBuffer));
                                System.out.println("打开的通信socket: " + clientChannel.socket());
                                System.out.println("打开的通信socket对象: " + clientChannel.hashCode());
                                byteBuffer.clear();
                            }

                            if((bytesRead <= 0)) {
                                System.out.println("客户端断开连接");
                                clientChannel.close();
                            }
                        }
                    }

                    selectionKeyIterator.remove();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
