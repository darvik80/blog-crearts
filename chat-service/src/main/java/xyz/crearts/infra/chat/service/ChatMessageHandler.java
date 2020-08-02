package xyz.crearts.infra.chat.service;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import xyz.crearts.infra.chat.codec.message.ChatMessage;

public class ChatMessageHandler extends SimpleChannelInboundHandler<ChatMessage> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ChatMessage msg) throws Exception {

    }
}
