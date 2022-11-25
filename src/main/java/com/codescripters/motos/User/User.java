package com.codescripters.motos.User;

import com.codescripters.motos.Motorcycle.Motorcycle;
import com.codescripters.motos.Utils.Gender;
import com.codescripters.motos.Utils.Role;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@RequiredArgsConstructor
@Document
public class User {
    @Id
    private String id;
    private final String firstName;
    private final String lastName;
    private final Gender gender;
    private final Role role;
    private final Integer documentNumber;
    private final Integer licenseNumber;
    private final String address;
    private final String city;
    private final Date dateOfBirth;
    private final Integer phoneNumber;
    private final String emailAddress;
    private final Motorcycle motorcycle;
    private final String createdBy;
    private final Date createdAt;
    private final Date updatedAt;
}
