package com.neueda.urlshortener.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neueda.urlshortener.model.Stats;

public class StatsController {
	private Stats stats;
	
	@RequestMapping(value = "/stats",method = RequestMethod.GET)
	public Stats stats(){
		return stats.getInstance();
	}

}
