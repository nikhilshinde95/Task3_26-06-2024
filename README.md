# Calculate API

This project is a REST API built using Spring Boot to perform various calculations on integers (0 to 9999). The calculations include finding the square, cube, checking if the number is even or odd, prime, Armstrong, palindrome, factorial, and reversing the number. Each calculation is performed using multithreading with different tasks for each calculation implemented using `Executor framework`.

## Features

- **Square Calculation**: Calculates the square of a given number.
- **Cube Calculation**: Calculates the cube of a given number.
- **Even/Odd Check**: Checks if a given number is even or odd.
- **Prime Check**: Checks if a given number is prime.
- **Armstrong Check**: Checks if a given number is an Armstrong number.
- **Palindrome Check**: Checks if a given number is a palindrome.
- **Factorial Calculation**: Calculates the factorial of a given number.
- **Reverse Number**: Reverses the digits of a given number.

## Requirements

- Java 8 or higher
- Maven or Gradle
- Spring Boot

## Installation

1. **Clone the repository**:
    
    git clone https://github.com/nikhilshinde95/Task3_26-06-2024.git
    cd calculation-api
    

2. **Build the project using gradle**:
    
3. **Run the application**:

## Usage

The API provides the following endpoints:

1. **Calculation**
    - **URL**: `http://localhost:9090/calculate?number=10`
    - **Method**: `POST`
    - **Parameters**: `number` (int)
    - **Example**: `http://localhost:9090/calculate?number=10`


 **Swagger Testing**
    - **URL**: `http://localhost:9090/swagger-ui/index.html#/calculation-controller/calculate`

**Swagger Testing Screenshot**

![Swagger_01](https://github.com/nikhilshinde95/Task3_26-06-2024/assets/171656624/337d0e7a-5be0-4a4b-a654-2797d800a4bc)

![Swagger_02](https://github.com/nikhilshinde95/Task3_26-06-2024/assets/171656624/02fd5df5-3222-425c-b65c-0a6eed58695e)

![Swagger_03](https://github.com/nikhilshinde95/Task3_26-06-2024/assets/171656624/79d90335-28e4-4793-91ca-746113762a64)

