package com.bjjdsy.amc.sys.mc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import com.bjjdsy.amc.sys.mc.scoketserver.server.WebsocketChatServer;

public class ApplicationStartup implements ApplicationListener<ContextRefreshedEvent> {

	private static final Logger logInfo = LoggerFactory.getLogger("log-info");

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		String applicationContextId = event.getApplicationContext().getId();
		logInfo.info("Application context id:" + applicationContextId);
		new Thread() {
			public void run() {
				WebsocketChatServer socketServer = (WebsocketChatServer) event.getApplicationContext()
						.getBean(WebsocketChatServer.class);
				try {
					socketServer.run();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}.start();
	}

}
