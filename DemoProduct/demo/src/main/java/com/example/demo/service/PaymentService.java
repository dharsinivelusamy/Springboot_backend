package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Payment;
import com.example.demo.repository.PaymentRepo;

@Service
public class PaymentService {
    
    @Autowired
    private PaymentRepo mdr;

    public Payment post(Payment md) {
        return mdr.save(md);
    }

    public Payment getDetail(int CustomerId) {
        return mdr.findById(CustomerId).orElse(null);
    }

    public boolean updateDetail(int id, Payment m) {
        if (this.getDetail(id) == null) {
            return false;
        }
        try {
            mdr.save(m);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean deleteDetail(int id) {
        if (this.getDetail(id) == null) {
            return false;
        }
        mdr.deleteById(id);
        return true;
    }
}