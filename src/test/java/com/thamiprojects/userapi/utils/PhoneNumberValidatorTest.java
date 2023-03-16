package com.thamiprojects.userapi.utils;

import com.thamiprojects.userapi.utilities.PhoneNumberValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.assertThat;

public class PhoneNumberValidatorTest {

    private PhoneNumberValidator phoneNumberValidator;
    @BeforeEach
    void setUp() {
        phoneNumberValidator = new PhoneNumberValidator();
    }

    @Test
    void itShouldValidatePhoneNumber() {
        //Given
        String phoneNumber = "+27721612718";

        //When
        boolean isValidPhoneNumber = phoneNumberValidator.test(phoneNumber);

        //Then
        assertThat(isValidPhoneNumber).isTrue();
    }
}
