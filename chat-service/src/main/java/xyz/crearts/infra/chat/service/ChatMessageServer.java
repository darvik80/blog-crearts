package xyz.crearts.infra.chat.service;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.extern.slf4j.Slf4j;
import xyz.crearts.infra.chat.codec.ChatMessageDecoder;
import xyz.crearts.infra.chat.codec.ChatMessageEncoder;
import xyz.crearts.infra.chat.configuration.ChatServerProperties;

@Slf4j
public class ChatMessageServer {
    private final ChatServerProperties properties;

    public ChatMessageServer(ChatServerProperties properties) {
        this.properties = properties;
        log.info("Create message server");
    }

    public void run() throws Exception {
        log.info("Run message server");
        EventLoopGroup bossGroup = new NioEventLoopGroup(); // (1)
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap bootstrap = new ServerBootstrap(); // (2)
            bootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class) // (3)
                    .childHandler(new ChannelInitializer<SocketChannel>() { // (4)
                        @Override
                        public void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast("encoder", new ChatMessageEncoder());
                            ch.pipeline().addLast("decoder", new ChatMessageDecoder());
                            ch.pipeline().addLast("handler", new ChatMessageDecoder());
                        }
                    })
                    .option(ChannelOption.SO_BACKLOG, 128)          // (5)
                    .childOption(ChannelOption.SO_KEEPALIVE, true); // (6)

            // Bind and start to accept incoming connections.
            log.info("Bind message server: {}", properties.getPort());
            ChannelFuture future = bootstrap.bind(properties.getPort()).sync(); // (7)

            // Wait until the server socket is closed.
            // In this example, this does not happen, but you can do that to gracefully
            // shut down your server.
            future.channel().closeFuture().sync();
        } finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }
}
