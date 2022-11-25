package com.codescripters.motos.User;

import com.codescripters.motos.Utils.UserModel;
import com.codescripters.motos.Utils.Utils;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.time.Instant;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.getUsers();
    }

    @PostMapping("/create")
    public User createUser(@RequestBody UserModel user) throws ParseException {
        Date createdAt = Utils.formatDate(Instant.now().toString());
        Date updatedAt = Utils.formatDate(Instant.now().toString());
        Date dateOfBirth = Utils.formatDate(user.getDateOfBirth());

        User userToCreate = new User(
                user.getFirstName(),
                user.getLastName(),
                user.getGender(),
                user.getRole(),
                user.getDocumentNumber(),
                user.getLicenseNumber(),
                user.getAddress(),
                "Medellin",
                dateOfBirth,
                user.getPhoneNumber(),
                user.getEmailAddress(),
                user.getMotorcycle(),
                user.getCreatedBy(),
                createdAt,
                updatedAt
        );
        return userService.saveUser(userToCreate);
    }
}
