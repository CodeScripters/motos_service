package com.codescripters.motos.User;

import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@AllArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final MongoTemplate mongoTemplate;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUser(BigInteger documentNumber) {
        Query query = new Query();
        query.addCriteria(Criteria.where("documentNumber").is(documentNumber));
        List<User> foundUsers = mongoTemplate.find(query, User.class);

        if(foundUsers.size() > 1) {
            throw new IllegalStateException("Multiple users found with document " + documentNumber.toString());
        }

        if(foundUsers.isEmpty()) {
            return null;
        }

        return foundUsers.get(0);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }
}
