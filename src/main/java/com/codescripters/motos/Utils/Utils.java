package com.codescripters.motos.Utils;

import com.codescripters.motos.Utils.exception.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

@AllArgsConstructor
public class Utils<T, ValueType> {
    private final MongoTemplate mongoTemplate;

    public T getOne(String fieldName, ValueType value, Class<T> cls) throws NotFoundException {
        Query query = new Query();
        query.addCriteria(Criteria.where(fieldName).is(value));
        List<T> result = mongoTemplate.find(query, cls);

        if(result.size() > 1) {
            throw new IllegalStateException("Multiple records found with value " + value.toString());
        }

        if(result.isEmpty()) {
            throw new NotFoundException("No record found with value " + value.toString());
        }

        return result.get(0);
    }
}
