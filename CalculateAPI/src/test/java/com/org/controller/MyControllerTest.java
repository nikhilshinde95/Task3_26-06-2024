package com.org.controller;

import com.org.services.ApplicationService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.concurrent.ExecutorService;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class MyControllerTest {

    @Mock
    private ApplicationService applicationService;
    
    @Mock
    private ExecutorService executorService;

    @InjectMocks
    private CalculationController calculationController;

    @Test
    public void testCalculate_Exception() {
        int number = 10;
        String errorMessage = "Calculation error";

        // Mock the behavior of applicationService.performCalculations() to throw an exception
        doThrow(new RuntimeException(errorMessage)).when(applicationService).performCalculations(number);

        // Call the calculate method
        String result = calculationController.calculate(number);

        // Verify that the result matches the expected error message
        assertEquals("Error occurred during calculations for number: " + number, result);

        // Verify that performCalculations was called with the correct argument
        verify(applicationService, times(1)).performCalculations(number);

        // Log error message
        System.out.println("Calculation test failed for number: " + number);
    }
}
