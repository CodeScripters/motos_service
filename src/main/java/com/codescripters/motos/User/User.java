package com.codescripters.motos.User;

import com.codescripters.motos.Motorcycle.Motorcycle;
import com.codescripters.motos.Utils.Gender;
import com.codescripters.motos.Utils.Role;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;
import java.time.LocalDate;

@Data
@RequiredArgsConstructor
@Document
public class User {
    @Id
    private String id;
    private final BigInteger documentNumber;
    private final String firstName;
    private final String lastName;
    private final Gender gender;
    private final Role role;
    private final BigInteger licenseNumber;
    private final String address;
    private final String city;
    private final LocalDate dateOfBirth;
    private final BigInteger phoneNumber;
    private final String emailAddress;
    private final Motorcycle motorcycle;
    private final String createdBy;
    private final LocalDate createdAt;
    private final LocalDate updatedAt;
}
