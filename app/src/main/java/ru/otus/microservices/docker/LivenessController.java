package ru.otus.microservices.docker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class LivenessController {

    @GetMapping("/health/")
    public Map<String, String> health() {
        return Map.of("status", "OK");
    }
}
