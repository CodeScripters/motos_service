package com.codescripters.motos.Utils;

import com.codescripters.motos.User.User;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
    public static Date formatDate(String date) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-M-dd");
        return formatter.parse(date);
    }

    public static boolean validate(User obj) {
        final Validator validator = Validation
                .buildDefaultValidatorFactory()
                .getValidator();

        return obj != null && validator.validate(obj)
                .stream()
                .map(ConstraintViolation::getMessage)
                .peek(System.err::println)
                .findAny()
                .isPresent();
    }
}
