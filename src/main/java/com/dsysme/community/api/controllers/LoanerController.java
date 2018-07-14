package com.dsysme.community.api.controllers;

import com.dsysme.community.api.models.Loaner;
import com.dsysme.community.api.repositories.LoanerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("loaners")
public class LoanerController {

    private LoanerRepository repository;

    @Autowired
    public void setRepository(LoanerRepository repository) {
        this.repository = repository;
    }

    @RequestMapping("/create")
    @PostMapping
    public Loaner createLoaner(@RequestBody Loaner loaner) {
        loaner.setId(UUID.randomUUID().toString());
        repository.save(loaner);
        return loaner;
    }

    @RequestMapping("{id}")
    @DeleteMapping
    public void deleteLoaner(@PathVariable("id") String id) {
        if (repository.findById(id).isPresent()) {
            repository.deleteById(id);
        }
    }

    @RequestMapping("/update/{id}")
    @PutMapping
    public Loaner updateLoaner(@PathVariable("id") String id, @RequestBody Loaner loaner) {
        if (repository.findById(id).isPresent()) {
            repository.save(loaner);
        }
        return loaner;
    }

    @RequestMapping("/")
    @GetMapping
    public Iterable<Loaner> getAll() {
        return repository.findAll();
    }

}
