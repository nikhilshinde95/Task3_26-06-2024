package com.org.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.org.services.ApplicationService;

@RestController
public class CalculationController {

    private static final Logger log = LoggerFactory.getLogger(CalculationController.class);

    @Autowired
    private ApplicationService applicationService;

    @PostMapping("/calculate")
    public String calculate(@RequestParam("number") int number) {
        log.info("Received request to calculate for number: {}", number);

        try {
            applicationService.performCalculations(number);
            log.info("Calculation tasks submitted for number: {}", number);
        } catch (Exception e) {
            log.error("Exception occurred while performing calculations for number {}: {}", number, e.getMessage());
            return "Error occurred during calculations for number: " + number;
        }

        return "Calculations initiated for number: " + number;
    }

    // Optionally, you may include a shutdown endpoint to gracefully shutdown the executor
    @PostMapping("/shutdown")
    public String shutdown() {
        applicationService.shutdownExecutor();
        return "Executor service shutdown initiated.";
    }
}
