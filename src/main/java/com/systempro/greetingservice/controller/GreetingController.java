package com.systempro.greetingservice.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.systempro.greetingservice.config.GreetingConfig;
import com.systempro.greetingservice.domain.Greeting;

@RestController
public class GreetingController {

	/*
	 * agora vamos ajustar os paramentos para receber informações dinamicas, isto é
	 * não vamos deixar setado como Hello, isto virá dos profiles, para isto vamos
	 * importar a config que fizemos e passr o paramentro para deixar dinamico.
	 */

	@Autowired
	private GreetingConfig config;

	private static final String template = "%s, %s!";
	private static final AtomicLong counter = new AtomicLong();

	@RequestMapping("greeting")
	public Greeting greeting(@RequestParam(value = "name", 
			defaultValue = "") String name) {
/*
 * como passamos parametros, setamos defaultValue como uma String vazia, e agora
 * importamos a configuration, abaixo estamos testando, se name vazio, passamos
 * por paramento o name pegando a configuration default.
 */
		if (name.isEmpty()) {
			name = config.getDefaultValue();
		}
		return new Greeting(counter.incrementAndGet(),
/*
 * agora para pegar as informações, precisamos expor as duas Strings, para isto
 * vamos pegar a config.getGreeting(). veja abaixo.
 */

				String.format(template,config.getGreeting(), name));
	}
}
