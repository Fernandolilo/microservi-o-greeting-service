package com.systempro.greetingservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/*
 * esta pegando as informações que lançamos como propiedade especial para lançar
 * no endpoint => @ConfigurationProperties("greeting-service")
 */
@Component
@ConfigurationProperties("greeting-service")
public class GreetingConfig {

	private String greeting;
	private String defaultValue;

	public GreetingConfig() {}

	public GreetingConfig(String greeting, String defaultValue) {
		this.greeting = greeting;
		this.defaultValue = defaultValue;
	}

	public String getGreeting() {
		return greeting;
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}

	public String getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

}
