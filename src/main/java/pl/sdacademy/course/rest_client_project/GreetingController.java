package pl.sdacademy.course.rest_client_project;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
	
	private static final String template = "Helo, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping("/greeting")
	 public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
	        return new Greeting(counter.incrementAndGet(),
	                            String.format(template, name));
	}
	

	@RequestMapping("/greeting/{name}")
	 public Greeting greeting1(@PathVariable(value="name") String name) {
	        return new Greeting(counter.incrementAndGet(),
	                            String.format(template, name));
	}
}
	

