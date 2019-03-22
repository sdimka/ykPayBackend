package com.springTest.controller;



import com.springTest.model.chempReg.ChempReg;
import com.springTest.service.chempRegService.ChempRegServiseImpl;
import com.springTest.service.mailSender.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.List;
import java.util.Locale;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/chemp_reg")
public class ChempRegController {

    @Autowired
    private ChempRegServiseImpl service;

    @Autowired
    private EmailService emailService;

    //---Get by id---
    @GetMapping("/{id}")
    public ResponseEntity<ChempReg> get(@PathVariable("id") long id) {
        ChempReg cr = service.get(id);
        return ResponseEntity.ok().body(cr);
    }

    //---get all ---
    @GetMapping("/")
    public ResponseEntity<List<ChempReg>> list() {
        List<ChempReg> cr = service.list();
        return ResponseEntity.ok().body(cr);
    }

    // ------ test send mail
    @GetMapping("/mailsend")
    public ResponseEntity<String> sendMail() {
        String recipientName = "Dmitriy";
        String recipientEmail = "s_d_a@mail.ru";
        Locale locale = Locale.ENGLISH;

        try {
            this.emailService.sendTextMail(recipientName, recipientEmail, locale);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        return ResponseEntity.ok().body("Got It!");
    }

    @PostMapping("/")
    public ResponseEntity<?> save(@RequestBody ChempReg chempReg) {

        long id = service.save(chempReg); // Сразу сохраняем в базу, на случай, если что-то случится
        String url = service.register(chempReg);

        url = "{ \"url\": \"" + url + "\"}";

        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(url);
    }
}
