package com.codescripters.motos.User;

import com.codescripters.motos.Utils.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers(@RequestParam Map<String, Object> params) {
        if(!params.isEmpty()) {
            return new ResponseEntity<>(
                    HttpStatus.BAD_REQUEST
            );
        }
        return new ResponseEntity<>(
                userService.getUsers(),
                HttpStatus.OK
        );
    }

    @GetMapping("/document/{userId}")
    public ResponseEntity<User> getOneUser(@PathVariable BigInteger userId) throws NotFoundException {
        User foundUser = userService.getUser(userId);

        return new ResponseEntity<>(
                foundUser,
                HttpStatus.OK
        );
    }

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody @Valid UserPOJO user) throws NotFoundException {
        User userFound = userService.getUser(user.getDocumentNumber());

        if(userFound == null) {
            LocalDate newDate = LocalDate.now();

            User userToCreate = new User(
                    user.getDocumentNumber(),
                    user.getFirstName(),
                    user.getLastName(),
                    user.getGender(),
                    user.getRole(),
                    user.getLicenseNumber(),
                    user.getAddress(),
                    "Medellin",
                    user.getDateOfBirth(),
                    user.getPhoneNumber(),
                    user.getEmailAddress(),
                    user.getMotorcycles(),
                    user.getCreatedBy(),
                    newDate,
                    newDate
            );

            return new ResponseEntity<>(
                    userService.saveUser(userToCreate),
                    HttpStatus.CREATED
            );
        }

        return new ResponseEntity<>(
                userFound,
                HttpStatus.BAD_REQUEST
        );
    }
}
