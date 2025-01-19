package io.github.jamielu.jamiecache.core;

import io.github.jamielu.jamiecache.core.CachePlugin;
import io.github.jamielu.jamiecache.netty.JmCacheDecode;
import io.github.jamielu.jamiecache.netty.JmCacheHandler;
import io.github.jamielu.jamiecache.netty.NettyFactory;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.epoll.EpollChannelOption;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author jamieLu
 * @create 2024-06-25
 */
@Component
@Slf4j
public class JmCacheServer implements CachePlugin {
    private EventLoopGroup bossGroup;
    private EventLoopGroup workerGroup;
    private Channel channel;

    private int port = 6379;
    @Override
    public void init() {
        bossGroup = NettyFactory.createBossGroup();
        workerGroup = NettyFactory.createWorkerGroup();
    }

    @Override
    public void startup() {
        log.info("prepare start up");
        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.option(ChannelOption.SO_BACKLOG, 128)
                .childOption(ChannelOption.TCP_NODELAY, Boolean.TRUE)
                .childOption(ChannelOption.SO_KEEPALIVE, true)
                .childOption(ChannelOption.SO_REUSEADDR, Boolean.TRUE)
                .childOption(ChannelOption.SO_RCVBUF, 32 * 1024)
                .childOption(ChannelOption.SO_SNDBUF, 32 * 1024)
                .childOption(EpollChannelOption.SO_REUSEPORT, true)
                .childOption(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT);
            bootstrap.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)
                .handler(new LoggingHandler(LogLevel.DEBUG))
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(new JmCacheDecode());
                            socketChannel.pipeline().addLast(new JmCacheHandler());
                        }
                    });
            channel = bootstrap.bind(port).channel();
            log.info("start netty redis sever:" + port);
            // 等待服务器 socket 关闭
            channel.closeFuture().sync();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }

    @Override
    public void shutdown() {
        if(this.channel != null) {
            this.channel.close();
            this.channel = null;
        }
        if(this.bossGroup != null) {
            this.bossGroup.shutdownGracefully();
            this.bossGroup = null;
        }
        if(this.workerGroup != null) {
            this.workerGroup.shutdownGracefully();
            this.workerGroup = null;
        }
    }
}
