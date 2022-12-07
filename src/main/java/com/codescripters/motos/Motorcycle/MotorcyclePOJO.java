package com.codescripters.motos.Motorcycle;

import com.codescripters.motos.User.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class MotorcyclePOJO {
    private static final String NULL_MESSAGE = "Must not be null or blank";

    @Null
    private String userDocument;

    @NotBlank(message = NULL_MESSAGE)
    @Size(min = 3, max = 60, message = "Should be at least 3 characters")
    private String plates;

    @NotBlank(message = NULL_MESSAGE)
    @Size(min = 3, max = 60, message = "Should be at least 3 characters")
    private String brandName;

    @NotNull(message = NULL_MESSAGE)
    @Digits(message = "Should have only 10 digits", integer = 10, fraction = 0)
    private Integer modelYear;

    @NotBlank(message = NULL_MESSAGE)
    @Size(min = 3, max = 60, message = "Should be at least 3 characters")
    private String createdBy;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
