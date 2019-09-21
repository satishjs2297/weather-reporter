package com.weather.info.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.weather.info.model.WeatherReport;
import com.weather.info.service.WeatherReportService;

@Controller
@RequestMapping("weather")
public class WeatherReportController {
	private static final Logger LOG = LoggerFactory.getLogger(WeatherReportController.class);

	private WeatherReportService weatherReportService;

	@Autowired
	public WeatherReportController(WeatherReportService weatherReportService) {
		this.weatherReportService = weatherReportService;
	}

	@RequestMapping(value = "/home")
	public String homePage() {
		LOG.debug("homePage Begin...");
		return "weather";
	}

	@RequestMapping(value = "/getWeathersByCities/{cities}")
	public @ResponseBody List<WeatherReport> getWeathersByCities(@PathVariable List<String> cities) {
		LOG.debug("Selected Cities :: {}", cities);
		return weatherReportService.getWeatherReportsByCities(cities);
	}

}
