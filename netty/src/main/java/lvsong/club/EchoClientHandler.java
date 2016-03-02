package lvsong.club;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

/**
 * Created by lvsong on 2/16/16.
 */
public class EchoClientHandler extends SimpleChannelInboundHandler<ByteBuf> {

    @Override
    protected void messageReceived(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
        System.out.println("Client received: " +
                ByteBufUtil.hexDump(msg.readBytes(msg.readableBytes())));
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        System.out.println("client init");

//        for (int i = 0; i < 100; i++) {
//            System.out.println("send...");
            // 这里的文本数据必须显示的注明\r\n，服务端的LineBasedFrameDecoder
            // 解半包处理器根据\r\n或者\n来判断数据是否属于两个不同的包
            ctx.writeAndFlush(Unpooled.copiedBuffer("Netty rocks!\r\n", CharsetUtil.UTF_8));
//        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        System.out.println("exception caught");
        cause.printStackTrace();
        ctx.close();
    }
}
