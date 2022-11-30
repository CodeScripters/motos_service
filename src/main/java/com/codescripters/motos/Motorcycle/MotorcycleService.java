package com.codescripters.motos.Motorcycle;

import com.codescripters.motos.Utils.Utils;
import com.codescripters.motos.Utils.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MotorcycleService {
    private final MotorcycleRepository motorcycleRepository;
    private final MongoTemplate mongoTemplate;

    public List<Motorcycle> getMotorcycles() {
        return motorcycleRepository.findAll();
    }

    public Motorcycle getMotorcycle(String plates) throws NotFoundException {
        Utils<Motorcycle, String> utils = new Utils<>(mongoTemplate);
        return (Motorcycle)utils.getOne("plates", plates, Motorcycle.class);
    }

    public Motorcycle saveMotorcycle(Motorcycle motorcycle) {
        return motorcycleRepository.save(motorcycle);
    }
}
