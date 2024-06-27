package com.org.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class ApplicationService {

    private static final Logger log = LoggerFactory.getLogger(ApplicationService.class);

    
    private final ExecutorService executor = Executors.newFixedThreadPool(8);

 
    public void performCalculations(int number) {
        executor.submit(() -> calculateSquare(number));
        executor.submit(() -> calculateCube(number));
        executor.submit(() -> checkEven(number));
        executor.submit(() -> checkPrime(number));
        executor.submit(() -> checkArmstrong(number));
        executor.submit(() -> checkPalindrome(number));
        executor.submit(() -> calculateFactorial(number));
        executor.submit(() -> calculateReverse(number));
    }

    private void calculateSquare(int number) {
        try {
            int square = number * number;
            log.info("Square of {}: {}", number, square);
        } catch (Exception e) {
            log.error("Exception occurred while calculating square for {}: {}", number, e.getMessage());
        }
    }

    private void calculateCube(int number) {
        try {
            int cube = number * number * number;
            log.info("Cube of {}: {}", number, cube);
        } catch (Exception e) {
            log.error("Exception occurred while calculating cube for {}: {}", number, e.getMessage());
        }
    }

    private void checkEven(int number) {
        try {
            boolean isEven = number % 2 == 0;
            log.info("{} is even: {}", number, isEven);
        } catch (Exception e) {
            log.error("Exception occurred while checking evenness for {}: {}", number, e.getMessage());
        }
    }

    private void checkPrime(int number) {
        try {
            boolean isPrime = true;
            if (number <= 1) {
                isPrime = false;
            } else {
                for (int i = 2; i <= Math.sqrt(number); i++) {
                    if (number % i == 0) {
                        isPrime = false;
                        break;
                    }
                }
            }
            log.info("{} is prime: {}", number, isPrime);
        } catch (Exception e) {
            log.error("Exception occurred while checking primality for {}: {}", number, e.getMessage());
        }
    }

    private void checkArmstrong(int number) {
        try {
            int original = number;
            int sum = 0;
            int digits = String.valueOf(number).length();
            int temp = number;
            while (temp > 0) {
                int digit = temp % 10;
                sum += Math.pow(digit, digits);
                temp /= 10;
            }
            boolean isArmstrong = original == sum;
            log.info("{} is Armstrong: {}", number, isArmstrong);
        } catch (Exception e) {
            log.error("Exception occurred while checking Armstrong number for {}: {}", number, e.getMessage());
        }
    }

    private void checkPalindrome(int number) {
        try {
            int original = number;
            int reverse = 0;
            int temp = number;
            while (temp != 0) {
                int digit = temp % 10;
                reverse = reverse * 10 + digit;
                temp /= 10;
            }
            boolean isPalindrome = original == reverse;
            log.info("{} is palindrome: {}", number, isPalindrome);
        } catch (Exception e) {
            log.error("Exception occurred while checking palindrome for {}: {}", number, e.getMessage());
        }
    }

    private void calculateFactorial(int number) {
        try {
            int factorial = 1;
            for (int i = 1; i <= number; i++) {
                factorial *= i;
            }
            log.info("Factorial of {}: {}", number, factorial);
        } catch (Exception e) {
            log.error("Exception occurred while calculating factorial for {}: {}", number, e.getMessage());
        }
    }

    private void calculateReverse(int number) {
        try {
            int reverse = 0;
            int temp = number;
            while (temp != 0) {
                reverse = reverse * 10 + temp % 10;
                temp /= 10;
            }
            log.info("Reverse of {}: {}", number, reverse);
        } catch (Exception e) {
            log.error("Exception occurred while calculating reverse for {}: {}", number, e.getMessage());
        }
    }

    // Shutdown executor service on application shutdown
    public void shutdownExecutor() {
        executor.shutdown();
    }
}
