package com.example.demojunit;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class ValidatorTests {

    @BeforeEach
    void beforeTests() {
        System.out.println("En Validator test methoder kommer nu köras..");
        Validator PhoneNumberValidator = new Validator();
    }
    @Test
    public void testValidPhoneNumber() {
        String validPhoneNumber = "0123456789";
        assertTrue(Validator.isPhoneNumberValid(validPhoneNumber));
    }
    @Test
    public void testPhoneNumberNotStartingWithZero() {
        String invalidPhoneNumber = "1234567890";
        assertFalse(Validator.isPhoneNumberValid(invalidPhoneNumber));
    }
    @Test
    public void testPhoneNumberLengthGreaterThanTen() {
        String invalidPhoneNumber = "0123456789012";
        assertFalse(Validator.isPhoneNumberValid(invalidPhoneNumber));
    }
    @Test
    public void testPhoneNumberContainsNonNumericCharacters() {
        String invalidPhoneNumber = "01Salim456";
        assertFalse(Validator.isPhoneNumberValid(invalidPhoneNumber));
    }
    @Test
    public void testPhoneNumberContainsValidCharacters() {
        String validPhoneNumber = "0123-456789";
        assertFalse(Validator.isPhoneNumberValid(validPhoneNumber));
    }
    @Test
    public void testPhoneNumberLengthLessThanSix() {
        String invalidPhoneNumber = "01234";
        assertFalse(Validator.isPhoneNumberValid(invalidPhoneNumber));
    }
    @AfterEach
    void afterTest() {
        System.out.println("En testmetod har nu avslutats");
    }
    @AfterAll
    static void tearDown() {
        System.out.println("Alla Validator testmetoder har nu körts...");
    }
}
