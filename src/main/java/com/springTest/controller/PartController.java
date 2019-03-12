package com.springTest.controller;

import com.springTest.model.Nomination;
import com.springTest.model.Part;
import com.springTest.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
        //List<Nomination> lis = new ArrayList<>();
        //lis.add(Nomination.builder().id(1).name("Bla-bla-bla").isSelected(true).build());
        //part.setNomination(lis);
        long id = service.save(part); // Сразу сохраняем в базу, на случай, если что-то случится
        String url = service.register(part);

        url = "{ \"url\": \"" + url + "\"}";

        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(url);
    }

    // ---- Lisen for new status sending by Yandex
    @PostMapping("/pstat")
    public ResponseEntity<?> getNewStatus(@RequestBody Part part) {
      //  String id = service.save(part);
      //  id = "{ \"url\": \"" + id + "\"}";
        return ResponseEntity.ok().build();
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
        List<Part> parts = service.list();
        return ResponseEntity.ok().body(parts);
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
