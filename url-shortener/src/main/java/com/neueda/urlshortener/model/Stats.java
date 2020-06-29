package com.neueda.urlshortener.model;

import java.time.Duration;
import java.time.LocalDateTime;

public class Stats {
	private static Stats single_instance = null;
	private int numberOfUrlsShortened;
	private int longestUrlShortened;
	private int shortestUrlShortened;
	private String serverStatus;
	private LocalDateTime serverStarted;
	private Duration serverUpTime;
	private final String additional_info;

	private Stats() {
		serverStarted = LocalDateTime.now();
		additional_info = "More information about the current status of the API is available at /actuator/health";
		serverStatus = "Up";
	}

	public String getAdditional_info() {
		return additional_info;
	}

	public static synchronized Stats getInstance() {
		if (single_instance == null) {
			single_instance = new Stats();
			return single_instance;
		}
		return single_instance;
	}

	public int getNumberOfUrlsShortened() {
		return numberOfUrlsShortened;
	}

	public void setNumberOfUrlsShortened(int numberOfUrlsShortened) {
		this.numberOfUrlsShortened = numberOfUrlsShortened;
	}

	public int getLongestUrlShortened() {
		return longestUrlShortened;
	}

	public void setLongestUrlShortened(int longestUrlShortened) {
		this.longestUrlShortened = longestUrlShortened;
	}

	public int getShortestUrlShortened() {
		return shortestUrlShortened;
	}

	public void setShortestUrlShortened(int shortestUrlShortened) {
		this.shortestUrlShortened = shortestUrlShortened;
	}

	public String getServerStatus() {
		return serverStatus;
	}

	public void setServerStatus(String serverStatus) {
		this.serverStatus = serverStatus;
	}

	public LocalDateTime getServerStarted() {
		return serverStarted;
	}

	public void setServerStarted(LocalDateTime serverStarted) {
		this.serverStarted = serverStarted;
	}

	public String getServerUpTime() {
		Duration duration = Duration.between(serverStarted, LocalDateTime.now());
		long seconds = duration.getSeconds();
		long absSeconds = Math.abs(seconds);
		String positive = String.format("%d:%02d:%02d", absSeconds / 3600, (absSeconds % 3600) / 60, absSeconds % 60);
		return seconds < 0 ? "-" + positive : positive;
	}

	public void setServerUpTime(Duration serverUpTime) {
		this.serverUpTime = serverUpTime;
	}
}
