package com.springTest.controller;

import com.springTest.model.Part;
import com.springTest.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class PartController {

    @Autowired
    private PartService service;

    //---Add new ---
    @PostMapping("/part")
    public ResponseEntity<?> save(@RequestBody Part part) {
        long id = service.save(part);
        return ResponseEntity.ok().body("New Part has been saved with ID:" + id);
    }

    //---Get by id---
    @GetMapping("/part/{id}")
    public ResponseEntity<Part> get(@PathVariable("id") long id) {
        Part part = service.get(id);
        return ResponseEntity.ok().body(part);
    }

    //---get all ---
    @GetMapping("/part")
    public ResponseEntity<List<Part>> list() {
        List<Part> books = service.list();
        return ResponseEntity.ok().body(books);
    }

    //---Update by id---
    @PutMapping("/part/{id}")
    public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Part part) {
        service.update(id, part);
        return ResponseEntity.ok().body("Part has been updated successfully.");
    }

    /*---Delete a book by id---*/
    @DeleteMapping("/part/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        service.delete(id);
        return ResponseEntity.ok().body("Part has been deleted successfully.");
    }
}
