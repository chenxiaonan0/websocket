package com.bjjdsy.amc.sys.mc.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Socket配置
 * 
 * @author chenxiaonan
 *
 */
@Configuration("socketConfig")
@ConfigurationProperties(prefix = "socketConfig")
public class SocketConfig {

	private int port;

	private int maxClient;

	private int heatBeatInterval;

	public final int getHeatBeatInterval() {
		return heatBeatInterval;
	}

	public final void setHeatBeatInterval(int heatBeatInterval) {
		this.heatBeatInterval = heatBeatInterval;
	}

	public final int getPort() {
		return port;
	}

	public final void setPort(int port) {
		this.port = port;
	}

	public final int getMaxClient() {
		return maxClient;
	}

	public final void setMaxClient(int maxClient) {
		this.maxClient = maxClient;
	}

}
