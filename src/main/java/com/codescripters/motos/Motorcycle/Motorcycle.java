package com.codescripters.motos.Motorcycle;

import com.codescripters.motos.User.User;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document
public class Motorcycle {
    @Id
    private String plates;
    private String brandName;
    private Integer modelYear;
    private User user;
    private String createdBy;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
