package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Payment;
import com.example.demo.service.PaymentService;

@RestController
public class PaymentController { 

    @Autowired
    private PaymentService mds;

    @PostMapping("/postdetails")
    public ResponseEntity<Payment> postMethodName(@RequestBody Payment md) {
        return new ResponseEntity<>(mds.post(md), HttpStatus.CREATED);
    }

    @GetMapping("/details/{CustomerId}")
    public ResponseEntity<Payment> getMethodName(@PathVariable("CustomerId") int CustomerId) {
        Payment mdtt = mds.getDetail(CustomerId);
        if (mdtt != null) {
            return new ResponseEntity<>(mdtt, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(mdtt, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/api/Payment/{CustomerId}")
    public ResponseEntity<Payment> putMethodName(@PathVariable("CustomerId") int id, @RequestBody Payment m) {
        if (mds.updateDetail(id, m)) {
            return new ResponseEntity<>(m, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/api/Payment/{CustomerId}")
    public ResponseEntity<Boolean> delete(@PathVariable("CustomerId") int id) {
        if (mds.deleteDetail(id)) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
    }
}