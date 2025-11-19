package ru.otus.microservices.management;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Map;

@RestController
public class ManagementController {
    private static final String METRICS_PATH = "/actuator/prometheus";

    @GetMapping("/health")
    public Map<String, String> health() {
        return Map.of("status", "OK");
    }

    @GetMapping("/metrics")
    public void metrics(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().getServletContext().getRequestDispatcher(METRICS_PATH).forward(request, response);
    }
}
