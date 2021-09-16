package com.bjjdsy.amc.sys.mc.scoketserver.handler;

import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.bjjdsy.amc.sys.mc.scoketserver.message.ChannelEntity;
import com.bjjdsy.amc.sys.mc.service.DataHandlerService;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

/**
 * 处理TextWebSocketFrame
 * 
 * @author chenxiaonan
 * @data 2017年5月17日
 */
@Component
public class WebSocketFrameHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

	private static Map<String, ChannelEntity> userWebSockets = new ConcurrentHashMap<String, ChannelEntity>();
	private static Map<String, Channel> nameWebSockets = new ConcurrentHashMap<String, Channel>();
	
	@Resource(name = "dataHandlerService")
	private DataHandlerService handlerService;
	
	@Override
	protected void messageReceived(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception { // 读取数据
		String text = msg.text();
		JSONObject s = JSONObject.parseObject(text);

		String userId = s.getString("userId");
		String postCode = s.getString("postCode");
		String orgCode = s.getString("orgCode");
		String orgType = s.getString("orgType");
		String msg1 = s.getString("msg");
		System.out.println(msg1);
		if (userWebSockets.containsKey(userId)) {
			userWebSockets.remove(userId);
		}else{
			sendMessage("============="+userId + "登陆了");
		}
		ChannelEntity entity = new ChannelEntity();
		entity.setUserId(userId);
		entity.setPostCode(postCode);
		entity.setOrgType(orgType);
		entity.setOrgCode(orgCode);
		entity.setMsg(msg1);
		entity.setChannel(ctx.channel());
		userWebSockets.put(userId, entity);
		String key = userId + "|" + ctx.channel().remoteAddress().toString();
		if (nameWebSockets.containsKey(key)) {
			nameWebSockets.remove(key);
		}
		nameWebSockets.put(key, ctx.channel());
		System.out.println(userId + "登陆了");
		
		if(!StringUtils.isEmpty(msg1)){
			sendMessage("用户"+userId+"说："+msg1);
		}
		
		//
		
		
	}

	private static void sendMessage(String msg){
		for (ChannelEntity value : userWebSockets.values()) {
			value.getChannel().writeAndFlush(new TextWebSocketFrame(msg));
			System.out.println("给" + value.getUserId() + "发送了推送！");
		}
	}
	
	@Override
	public void handlerAdded(ChannelHandlerContext ctx) throws Exception { // 连接时调用
		/*
		 * Channel incoming = ctx.channel();
		 * System.out.println("Client:"+incoming.remoteAddress() +"加入");
		 */
	}

	@Override
	public void handlerRemoved(ChannelHandlerContext ctx) throws Exception { // 移除时调用
		String channel = "";
		String userId = "";
		String removeKey = "";
		String[] temp = null;

		for (Entry<String, Channel> entry : nameWebSockets.entrySet()) {
			temp = entry.getKey().split("\\|");
			channel = temp[1];
			userId = temp[0];
			if (channel.equals(ctx.channel().remoteAddress().toString())) {
				removeKey = entry.getKey();
				break;
			}
		}
		nameWebSockets.remove(removeKey);
		userWebSockets.remove(userId);

		/*
		 * Channel incoming = ctx.channel();
		 * System.out.println("Client:"+incoming.remoteAddress() +"离开");
		 */

	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		/*
		 * Channel incoming = ctx.channel();
		 * System.out.println("Client:"+incoming.remoteAddress()+"在线");
		 */
	}

	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		/*
		 * Channel incoming = ctx.channel();
		 * System.out.println("Client:"+incoming.remoteAddress()+"掉线");
		 */
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) // 异常则关闭
			throws Exception {
		/*
		 * Channel incoming = ctx.channel();
		 * System.out.println("Client:"+incoming.remoteAddress()+"异常");
		 */
		// 当出现异常就关闭连接
		cause.printStackTrace();
		ctx.close();
	}

	public Map<String, ChannelEntity> returnMap() {
		return userWebSockets;
	}

}
