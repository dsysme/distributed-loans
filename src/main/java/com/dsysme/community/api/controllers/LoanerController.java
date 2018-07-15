package com.dsysme.community.api.controllers;

import com.dsysme.community.api.models.Loaner;
import com.dsysme.community.api.repositories.LoanerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("loaners")
public class LoanerController {

    private LoanerRepository repository;

    @Autowired
    public void setRepository(LoanerRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Loaner createLoaner(@RequestBody Loaner loaner) {
        loaner.setId(UUID.randomUUID().toString());
        return repository.save(loaner);
    }

    @DeleteMapping("{id}")
    public void deleteLoaner(@PathVariable("id") String id) {
        // TODO how do I delete all dependencies? need I explicitly state the dependencies in a specialized repository function?
        repository.deleteById(id);
    }

    @PutMapping("{id}")
    public Optional<Loaner> updateLoaner(@PathVariable("id") String id, @RequestBody Loaner loaner) {
        // TODO: implement a method in the repository that will allow to do this in one access
        if (repository.findById(id).isPresent()) {
            loaner.setId(id);
            Optional.of(repository.save(loaner)); // TODO: shows null here should I handle differently?
        }
        return Optional.empty();
    }

    @GetMapping
    public Iterable<Loaner> getAll() {
        return repository.findAll();
    }

}
