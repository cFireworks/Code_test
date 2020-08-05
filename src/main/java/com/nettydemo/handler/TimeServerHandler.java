package com.nettydemo.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @description: 时间服务器
 * @author: cfireworks
 * @create: 2020-08-05 23:07
 **/
public class TimeServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        final ByteBuf time = ctx.alloc().buffer(4);
        time.writeInt((int)(System.currentTimeMillis()/1000L+2208988800L));

        final ChannelFuture f = ctx.writeAndFlush(time);
        f.addListener((ChannelFutureListener) channelFuture -> {
            assert f == channelFuture;
            ctx.close();
        });
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
