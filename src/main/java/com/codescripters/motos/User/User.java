package com.codescripters.motos.User;

import com.codescripters.motos.Motorcycle.Motorcycle;
import com.codescripters.motos.Utils.Gender;
import com.codescripters.motos.Utils.Role;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.*;
import java.math.BigInteger;
import java.util.Date;

@Data
@RequiredArgsConstructor
@Document
public class User {
    @Id
    @NotNull
    @NotBlank
    private String id;
    @NotNull
    @Size(min = 7, max = 10)
    private final BigInteger documentNumber;
    @NotNull
    @NotBlank
    @Size(min = 7)
    private final String firstName;
    @NotNull
    @NotBlank
    @Size(min = 7)
    private final String lastName;
    @NotNull
    @NotBlank
    @NotEmpty
    private final Gender gender;
    @NotNull
    @NotBlank
    @NotEmpty
    private final Role role;
    @NotNull
    @Size(min = 7, max = 10)
    private final BigInteger licenseNumber;
    @NotNull
    @NotBlank
    @Size(min = 7, max = 30)
    private final String address;
    @NotNull
    @NotBlank
    @Size(min = 7, max = 50)
    private final String city;
    @NotNull
    @NotEmpty
    @NotBlank
    @Past
    @Size(min = 3)
    private final Date dateOfBirth;
    @NotNull
    @Size(min = 8, max = 10)
    private final BigInteger phoneNumber;
    @NotNull
    @NotBlank
    @Email
    @Size(min = 7)
    private final String emailAddress;
    private final Motorcycle motorcycle;
    @NotNull
    @NotBlank
    @Size(min = 4)
    private final String createdBy;
    @NotNull
    @NotEmpty
    @NotBlank
    @Past
    @Size(min = 3)
    private final Date createdAt;
    @NotNull
    @NotEmpty
    @NotBlank
    @Past
    @Size(min = 3)
    private final Date updatedAt;
}
