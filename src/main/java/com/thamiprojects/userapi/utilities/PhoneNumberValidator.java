package com.thamiprojects.userapi.utilities;

import java.util.function.Predicate;

public class PhoneNumberValidator implements Predicate<String> {
    @Override
    public boolean test(String phoneNumber) {
        return phoneNumber.startsWith("+27") && phoneNumber.length() == 12;
    }
}
