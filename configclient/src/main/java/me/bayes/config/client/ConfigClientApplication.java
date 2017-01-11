package me.bayes.config.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class ConfigClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigClientApplication.class, args);
	}


	@RefreshScope
	@RestController("/api")
	public static class SampleController {

		public String message;

		@Autowired
		public SampleController(@Value("${message}") String message) {
			this.message = message;
		}

		@RequestMapping(value = "/api/message", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
		public String api() {

			return this.message;
		}
	}
}
