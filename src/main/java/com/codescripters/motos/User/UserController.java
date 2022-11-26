package com.codescripters.motos.User;

import com.codescripters.motos.Utils.Utils;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.text.ParseException;
import java.time.Instant;
import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/all")
    public ResponseEntity<Object> getAllUsers(@RequestParam Map<String, Object> params) {
        if(!params.isEmpty()) {
            return new ResponseEntity<>(
                    "The REQUEST does not allow parameters",
                    HttpStatus.BAD_REQUEST
            );
        }
        return new ResponseEntity<>(
                userService.getUsers(),
                HttpStatus.OK
        );
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Object> getOneUser(@PathVariable BigInteger userId) {
        User foundUser = userService.getUser(userId);

        if(foundUser == null) {
            return new ResponseEntity<>(
              "User with document " + userId.toString() + " not found",
              HttpStatus.NOT_FOUND
            );
        }

        return new ResponseEntity<>(
                foundUser,
                HttpStatus.OK
        );
    }

    @PostMapping("/create")
    public ResponseEntity<Object> createUser(@RequestBody UserPOJO user) throws ParseException {
        User userFound = userService.getUser(user.getDocumentNumber());

        if(userFound == null) {
            Date createdAt = Utils.formatDate(Instant.now().toString());
            Date updatedAt = Utils.formatDate(Instant.now().toString());
            Date dateOfBirth = Utils.formatDate(user.getDateOfBirth());

            User userToCreate = new User(
                    user.getDocumentNumber(),
                    user.getFirstName(),
                    user.getLastName(),
                    user.getGender(),
                    user.getRole(),
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

            return new ResponseEntity<>(
                    userService.saveUser(userToCreate),
                    HttpStatus.CREATED
            );
        }

        return new ResponseEntity<>(
                "The user with document " + user.getDocumentNumber().toString() + " already exists",
                HttpStatus.BAD_REQUEST
        );
    }
}
