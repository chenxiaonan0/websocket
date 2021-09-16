package com.bjjdsy.amc.sys.mc.scoketserver.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bjjdsy.amc.sys.mc.config.SocketConfig;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * Websocket 服务端
 * 
 * @author chenxiaonan
 * @data 2017年5月17日
 */
@Component
public class WebsocketChatServer {

	@Autowired
	private SocketConfig config;

	public void run() throws Exception {

		EventLoopGroup bossGroup = new NioEventLoopGroup();
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		try {
			ServerBootstrap b = new ServerBootstrap();
			b.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class) //
					.childHandler(new WebsocketChatServerInitializer()) // 处理初始化类
					.option(ChannelOption.SO_BACKLOG, 1024).childOption(ChannelOption.SO_KEEPALIVE, true); // 保持长连接
			// System.out.println("WebsocketChatServer 启动了" + config.getPort());
			// 绑定端口，开始接收进来的连接
			ChannelFuture f = b.bind(config.getPort()).sync(); //
			// 等待服务器 socket 关闭 。
			f.channel().closeFuture().sync();

		} finally {
			workerGroup.shutdownGracefully();
			bossGroup.shutdownGracefully();
		}
	}
}
