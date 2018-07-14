package com.dsysme.community.api.controllers;

import com.dsysme.community.api.models.Item;
import com.dsysme.community.api.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("items")
public class ItemController {

    private ItemRepository repository;

    @Autowired
    public void setRepository(ItemRepository repository) {
        this.repository = repository;
    }

    @RequestMapping("/")
    @GetMapping
    public Iterable<Item> getAll() {
        return this.repository.findAll();
    }

    @RequestMapping("/create")
    @PostMapping
    public Item createItem(@RequestBody Item item) {
        return repository.save(item);
    }

    @RequestMapping("{id}")
    @DeleteMapping
    public void deleteItem(@PathVariable("id") Integer id) {
        if (repository.findById(id).isPresent()) {
            repository.deleteById(id);
        }
    }

    @RequestMapping("/update/{id}")
    @PutMapping
    public Optional<Item> updateItem(@PathVariable("id") Integer  id, @RequestBody Item item) {
        if(repository.findById(id).isPresent()) {
            item.setId(id);
            return Optional.of(repository.save(item));
        }
        return Optional.empty();
    }
}
