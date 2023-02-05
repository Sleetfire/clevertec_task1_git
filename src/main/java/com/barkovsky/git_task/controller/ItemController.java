package com.barkovsky.git_task.controller;

import com.barkovsky.git_task.model.dto.Item;
import com.barkovsky.git_task.service.api.IItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/item")
public class ItemController {

    private final IItemService iItemService;

    public ItemController(IItemService iItemService) {
        this.iItemService = iItemService;
    }

    @PostMapping(value = {"/", ""},
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Item> create(@RequestBody Item item) {
        return new ResponseEntity<>(this.iItemService.create(item), HttpStatus.CREATED);
    }

    @GetMapping(value = "/{uuid}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Item> get(@PathVariable UUID uuid) {
        return new ResponseEntity<>(this.iItemService.get(uuid), HttpStatus.OK);
    }

    @GetMapping(value = {"/", ""}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Item>> getAll() {
        return new ResponseEntity<>(this.iItemService.getAll(), HttpStatus.OK);
    }

}
