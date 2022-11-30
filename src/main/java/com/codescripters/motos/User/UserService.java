package com.codescripters.motos.User;

import com.codescripters.motos.Utils.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import com.codescripters.motos.Utils.*;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final MongoTemplate mongoTemplate;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUser(BigInteger documentNumber) throws NotFoundException {
        Utils<User, BigInteger> utils = new Utils<>(mongoTemplate);
        return (User)utils.getOne("documentNumber", documentNumber, User.class);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }
}
