package com.codescripters.motos.Motorcycle;

import com.codescripters.motos.User.User;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@RequiredArgsConstructor
@Document
public class Motorcycle {
    @Id
    private String id;
    private final String plates;
    private final String brandName;
    private final Integer modelYear;
    private final User user;
    private final String createdBy;
    private final LocalDate createdAt;
    private final LocalDate updatedAt;
}
