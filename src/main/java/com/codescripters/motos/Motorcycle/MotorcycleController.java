package com.codescripters.motos.Motorcycle;

import com.codescripters.motos.Utils.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/motorcycle")
@AllArgsConstructor
public class MotorcycleController {
    private final MotorcycleService motorcycleService;

    @GetMapping("/all")
    public ResponseEntity<List<Motorcycle>> getAllMotorcycles(@RequestParam Map<String, Object> params) {
        if(!params.isEmpty()) {
            return new ResponseEntity<>(
                    HttpStatus.BAD_REQUEST
            );
        }

        return new ResponseEntity<>(
                motorcycleService.getMotorcycles(),
                HttpStatus.OK
        );
    }

    @GetMapping("/plate/{plates}")
    public ResponseEntity<Motorcycle> getOneMotorcycle(@PathVariable String plates) throws NotFoundException {
        Motorcycle motorcycleFound = motorcycleService.getMotorcycle(plates);

        return new ResponseEntity<>(
                motorcycleFound,
                HttpStatus.OK
        );
    }

    @PostMapping("/create")
    public ResponseEntity<Motorcycle> createMotorcycle(@RequestBody @Valid MotorcyclePOJO motorcyclePOJO) throws NotFoundException {
        Motorcycle motorcycleFound = motorcycleService.getMotorcycle(motorcyclePOJO.getPlates());

        if(motorcycleFound == null) {
            LocalDate newDate = LocalDate.now();

            Motorcycle motorcycleToCreate = new Motorcycle(
                    motorcyclePOJO.getPlates(),
                    motorcyclePOJO.getUserDocument(),
                    motorcyclePOJO.getBrandName(),
                    motorcyclePOJO.getModelYear(),
                    motorcyclePOJO.getCreatedBy(),
                    newDate,
                    newDate
            );

            return new ResponseEntity<>(
                    motorcycleService.saveMotorcycle(motorcycleToCreate),
                    HttpStatus.CREATED
            );
        }

        return new ResponseEntity<>(
                motorcycleFound,
                HttpStatus.BAD_REQUEST
        );
    }
}
