package ar.com.ada.sb.api.crud.controller;

import ar.com.ada.sb.api.crud.model.dto.DogDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/dogs")
public class DogController {

    @GetMapping({"","/"})
    private ResponseEntity getAllDogs() {
        List<DogDTO> dogs = new ArrayList<>();
        dogs.add(new DogDTO(1l, "Caniche", "Macho"));
        dogs.add(new DogDTO(2l, "Puddle", "Macho"));
        dogs.add(new DogDTO(3l, "Boxer", "Macho"));

        return ResponseEntity.ok().body(dogs);
    }

    @PostMapping({"","/"})
    private ResponseEntity addNewDog(@RequestBody DogDTO dog) throws URISyntaxException {
        int id = (int) (Math.random() * (1000 - 1) + 1);
        dog.setId(Integer.toUnsignedLong(id));
        return ResponseEntity
                .created(new URI("/dogs/" + dog.getId()))
                .body(dog);
    }

    @GetMapping("/{id}")
    private ResponseEntity getById(@PathVariable Long id) {
        DogDTO dog = new DogDTO(id, "Maltez Toy", "Hembra");

        return ResponseEntity.ok().body(dog);
    }

    @PutMapping("/{id}")
    private ResponseEntity updateDog(@RequestBody DogDTO dog, @PathVariable Long id) {
        dog.setId(id);
        return  ResponseEntity.ok().body(dog);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity deleteDog(@PathVariable Long id) {
        return ResponseEntity.noContent().build();
    }
}
