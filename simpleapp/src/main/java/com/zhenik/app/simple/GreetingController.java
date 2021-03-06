package com.zhenik.app.simple;

import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    private final Environment env;
    private static final Logger LOG = LoggerFactory.getLogger(GreetingController.class);
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    public GreetingController(Environment env) {this.env = env;}

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        long counter = this.counter.incrementAndGet();
        LOG.info("/greeting endpoint with count {}", counter);
        return new Greeting(counter, String.format(template, name));
    }

    @GetMapping("/info")
    public String logInfo() {
        LOG.info("Logging INFO");
        return "Logging INFO";
    }


    @GetMapping("/err")
    public String logError() {
        LOG.info("Logging ERROR");
        return "Logging ERROR";
    }

    @GetMapping("/env/{key}")
    public String getEnv(@PathVariable String key) {
        LOG.info("Get key - {}", key);
        return env.getProperty(key);
    }
}
