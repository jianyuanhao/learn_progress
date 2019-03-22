package com.joy.fresh.test.nettycode;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;

/**
 * Created by jianyuanhao on 18-11-11.
 */
public class ReactorTest {
    public static void main(String[] args) {
        // 单线程Reactor
        EventLoopGroup boss = new NioEventLoopGroup(1);
        ServerBootstrap b = new ServerBootstrap().group(boss, boss);
        // 多线程Reactor-线程池
        EventLoopGroup boss1 = new NioEventLoopGroup(1);
        ServerBootstrap b1 = new ServerBootstrap().group(boss, boss);
        // Multiple Reactor-Multiple Reactor，所有逻辑都在线程中完成 ，不单独启线程
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        ServerBootstrap b2 = new ServerBootstrap().group(bossGroup, workerGroup);

    }
}
