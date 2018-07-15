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

    @GetMapping("{id}")
    public Optional<Item> getItem(@PathVariable Integer id) {
        return repository.findById(id);
    }

    @GetMapping
    public Iterable<Item> getAll() {
        return this.repository.findAll();
    }

    @PostMapping
    public Item createItem(@RequestBody Item item) {
        // TODO after create the returned element doesn't contain all owners details (I only passed id) should I do something about it or will a true client pass all information?
        return repository.save(item);
    }

    @DeleteMapping("{id}")
    public void deleteItem(@PathVariable("id") Integer id) {
        repository.deleteById(id);
    }

    @PutMapping("{id}")
    public Optional<Item> updateItem(@PathVariable("id") Integer  id, @RequestBody Item item) {
        // TODO: implement a method in the repository that will allow to do this in one access
        if(repository.findById(id).isPresent()) {
            item.setId(id);
            return Optional.of(repository.save(item));
        }
        return Optional.empty();
    }
}
