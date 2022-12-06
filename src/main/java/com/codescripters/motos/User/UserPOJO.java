package com.codescripters.motos.User;

import com.codescripters.motos.Motorcycle.Motorcycle;
import com.codescripters.motos.Utils.Gender;
import com.codescripters.motos.Utils.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class UserPOJO {
    private static final String NULL_MESSAGE = "Must not be null or blank";

    @NotNull(message = NULL_MESSAGE)
    @Digits(message = "Should have only 10 digits", integer = 10, fraction = 0)
    private BigInteger documentNumber;

    @NotBlank(message = NULL_MESSAGE)
    @Size(min = 3, max = 60, message = "Should be at least 3 characters")
    private String firstName;

    @NotBlank(message = NULL_MESSAGE)
    @Size(min = 3, max = 60, message = "Should be at least 3 characters")
    private String lastName;

    @NotNull(message = NULL_MESSAGE)
    private Gender gender;

    @NotNull(message = NULL_MESSAGE)
    private Role role;

    @NotNull(message = NULL_MESSAGE)
    @Digits(message = "Should have only 10 digits", integer = 10, fraction = 0)
    private BigInteger licenseNumber;

    @NotBlank(message = NULL_MESSAGE)
    @Size(min = 7, max = 30, message = "Should be at least 7 characters")
    private String address;

    private String city;

    @NotNull(message = NULL_MESSAGE)
    @Past(message = "Must not be in the future")
    private LocalDate dateOfBirth;

    @NotNull(message = NULL_MESSAGE)
    @Digits(message = "Should have only 10 digits", integer = 10, fraction = 0)
    private BigInteger phoneNumber;

    @NotBlank(message = NULL_MESSAGE)
    @Email(message = "Should be a valid email address")
    @Size(min = 7, message = "Should be at least 7 characters")
    private String emailAddress;

    private List<Motorcycle> motorcycles;

    @NotBlank(message = NULL_MESSAGE)
    @Size(min = 4, message = "Should be at least 4 characters")
    private String createdBy;

    private LocalDate createdAt;

    private LocalDate updatedAt;
}