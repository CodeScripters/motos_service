package com.codescripters.motos.Motorcycle;

import com.codescripters.motos.User.User;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
@Document
public class MotorcyclePOJO {
    private static final String NULL_MESSAGE = "Must not be null or blank";

    @NotBlank(message = NULL_MESSAGE)
    @Size(min = 3, max = 60, message = "Should be at least 3 characters")
    private String plates;

    @NotBlank(message = NULL_MESSAGE)
    @Size(min = 3, max = 60, message = "Should be at least 3 characters")
    private String brandName;

    @NotNull(message = NULL_MESSAGE)
    @Digits(message = "Should have only 10 digits", integer = 10, fraction = 0)
    private Integer modelYear;

    private User user;

    @NotBlank(message = NULL_MESSAGE)
    @Size(min = 3, max = 60, message = "Should be at least 3 characters")
    private String createdBy;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
