package com.dsysme.community.api.controllers;

import com.dsysme.community.api.models.Loan;
import com.dsysme.community.api.repositories.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;

@RestController
@RequestMapping("loans")
public class LoanController {

    private LoanRepository repository;

    @Autowired
    public void setRepository(LoanRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public Iterable<Loan> getAll() {
        return repository.findAll();
    }

    @GetMapping("{id}")
    public Optional<Loan> getLoan(@PathVariable("id") Integer id) {
        return repository.findById(id);
    }

    @PostMapping
    public Loan createLoan(@RequestBody Loan loan) {
        // TODO check validity of a loan (you can't loan a book that is already loaned)
        return repository.save(loan);
    }

    @PutMapping("{id}")
    public Iterable<Loan> updateLoan(@PathVariable("id") Integer id, @RequestBody Loan loan) {
        // TODO: implement a method in the repository that will allow to do this in one access
        Optional<Loan> optionalLoan = repository.findById(id);
        if (optionalLoan.isPresent()) {
           loan.setId(id);
           return Arrays.asList(repository.save(loan));
        }
        return Collections.emptyList();
    }

}
