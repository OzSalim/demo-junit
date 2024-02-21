package com.example.demojunit;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CalculatorTests {
    Calculator calculator;

    @BeforeAll
    static void setup() {
        System.out.println("Testklassen kommer nu att instansieras");
    }

    @BeforeEach
    void beforeTests() {
        System.out.println("En test method kommer nu köras..");
        calculator = new Calculator();
    }
    @Test
    @DisplayName("Adding two numbers should return sum")
    void addingTwoNumbers(){
        int a = 3;
        int b = 2;
        int result = calculator.add(a, b);
        assertEquals(5, result);
    }
    @Test
    void addingTwoNumbersShouldNotReturnFive() {
        int a = 3;
        int b = 3;
        int result = calculator.add(a, b);
        Assertions.assertNotEquals(5, result);
    }
    @Test
    void testSubtract() {
        int a = 5;
        int b = 3;
        int result = calculator.subtract(a,b);
        assertEquals(2, result);
    }
    @Test
    void testMultiply() {
        int a = 5;
        int b = 3;
        int result = calculator.multiply(a,b);
        assertEquals(15, result);
    }
    @Test
    void testDivide() {
        int a = 6;
        int b = 2;
        double result = calculator.divide(a,b);
        assertEquals(3, result);
    }
    @Test
    void testSquareRootOf() {
        int a = 4;
        double result = calculator.squareRootOf(a);
        assertEquals(2.0, result);
    }
    @AfterEach
    void afterTest() {
        System.out.println("En testmetod har nu avslutats");
    }
    @AfterAll
    static void tearDown() {
        System.out.println("Alla testmetod har nu körts...");
    }
}
