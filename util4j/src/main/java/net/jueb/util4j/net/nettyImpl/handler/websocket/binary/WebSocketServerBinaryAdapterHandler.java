package net.jueb.util4j.net.nettyImpl.handler.websocket.binary;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import net.jueb.util4j.net.nettyImpl.handler.websocket.WebSocketServerInitializer;
import net.jueb.util4j.net.nettyImpl.handler.websocket.binary.codec.WebSocketBinaryFrameByteBufAdapter;

/**
 * websocket服务端handler适配器
 * @author Administrator
 */
public  class WebSocketServerBinaryAdapterHandler extends WebSocketServerInitializer{

	private ChannelHandler handler;
	public WebSocketServerBinaryAdapterHandler(String uri,ChannelHandler handler) {
		super(uri);
		this.handler=handler;
	}

	@Override
	protected void webSocketHandComplete(ChannelHandlerContext ctx) {
		ctx.channel().pipeline().addLast(new WebSocketBinaryFrameByteBufAdapter());//适配器
		ctx.channel().pipeline().addLast(handler);
		//为新加的handler手动触发必要事件
		ctx.fireChannelRegistered();
		ctx.fireChannelActive();
	}
}
