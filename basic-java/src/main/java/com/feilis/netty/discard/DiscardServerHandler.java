package com.feilis.netty.discard;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

/**
 * @ClassName DiscardServerHandler
 * @Description TODO
 * @Author lf199
 * @Date 2021/6/21 10:28
 * @Version V1.0
 */
public class DiscardServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        //super.channelRead(ctx, msg);
        //丢弃所接受搞得任何数据
        //((ByteBuf) msg).release();
        //ByteBuf inMsg = (ByteBuf) msg;
//        try {
//            while (inMsg.isReadable()) {
//                System.out.println((char) inMsg.readByte());
//                System.out.flush();
//            }
//        } finally {
//            ReferenceCountUtil.release(msg);
//        }

        ctx.writeAndFlush(msg);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        //close the connection when an exception is closed
        super.exceptionCaught(ctx, cause);
        ctx.close();
    }
}
