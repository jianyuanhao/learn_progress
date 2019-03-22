package com.joy.fresh.netty.sample.client;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * Created by jianyuanhao on 18-11-20.
 */
public class EchoClient {
    private final String host;
    private final int port;

    public EchoClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void start() throws Exception {
        EventLoopGroup group = new NioEventLoopGroup();
        try {

            Bootstrap b = new Bootstrap();
            b.group(group).channel(NioSocketChannel.class).remoteAddress(new InetSocketAddress(host, port))
                    .handler(new ChannelInitializer<io.netty.channel.socket.SocketChannel>() {
                        @Override
                        protected void initChannel(io.netty.channel.socket.SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new EchoClientHandler());
                        }
                    });
            ChannelFuture f = b.connect().sync();
            ByteBuf buffer= Unpooled.copiedBuffer("you are beautiful", Charset.defaultCharset());
            f.channel().writeAndFlush(buffer);
            f.channel().closeFuture().sync();

        } finally {
            group.shutdownGracefully().sync();

        }
    }

    public static void main(String[] args) throws Exception {
        // if (args.length != 2) {
        // System.out.println("Usage:" + EchoClient.class.getSimpleName() + "<host> <port>");
        // return;
        // }
        // String host = args[0];
        // int port = Integer.parseInt(args[1]);
        new EchoClient("127.0.0.1", 3388).start();
    }
}
