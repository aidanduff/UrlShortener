package com.neueda.urlshortener.util;

import com.neueda.urlshortener.model.Stats;

public class StatsHelper {
	Stats stats = Stats.getInstance();

	public void checkIfLongest(String originalUrl) {
		if (originalUrl.length() > stats.getLongestUrlShortened()) {
			stats.setLongestUrlShortened(originalUrl.length());
		}
	}

	public void checkIfShortest(String shortenedUrl) {
		if (stats.getShortestUrlShortened() == 0) {
			stats.setShortestUrlShortened(shortenedUrl.length());
		}
		if (shortenedUrl.length() < stats.getShortestUrlShortened()) {
			stats.setShortestUrlShortened(shortenedUrl.length());
		}
	}

}
