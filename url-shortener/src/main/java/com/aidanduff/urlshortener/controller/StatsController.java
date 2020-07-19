package com.aidanduff.urlshortener.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aidanduff.urlshortener.model.Stats;

@RestController
public class StatsController {
	private Stats stats;
	
	@RequestMapping(value = "/stats",method = RequestMethod.GET)
	public Stats stats(){
		return stats.getInstance();
	}

}
