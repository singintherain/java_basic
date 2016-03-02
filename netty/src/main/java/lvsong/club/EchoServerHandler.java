package lvsong.club;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.util.CharsetUtil;

/**
 * Created by lvsong on 2/16/16.
 */
@ChannelHandler.Sharable
public class EchoServerHandler extends ChannelHandlerAdapter {
    private int counter = 0;

    /**
     * 检测是否出现了tcp粘包
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//        String body = (String)msg;
        ByteBuf buf = (ByteBuf)msg;
        byte[] req = new byte[buf.readableBytes()];
        buf.readBytes(req);
        String body = new String(req, "UTF-8");
        System.out.println("Server received: " + body);
        System.out.println("Channel local address: " + ctx.channel().localAddress());
        System.out.println("Channel remote address: " + ctx.channel().remoteAddress());
        System.out.println("Server received, the counter is " + (counter++));
        System.out.println("Channel Handler Thread id " + Thread.currentThread().getId());

        ctx.writeAndFlush(Unpooled.copiedBuffer(body, CharsetUtil.UTF_8));
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.writeAndFlush(Unpooled.EMPTY_BUFFER)
                .addListener(ChannelFutureListener.CLOSE);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        System.out.println("server exception");
        cause.printStackTrace();
        ctx.close();
    }
}
