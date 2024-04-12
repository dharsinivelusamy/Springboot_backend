package com.example.demo.controller;

import java.util.List;

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

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;



@RestController
public class ProductController {
    @Autowired
    ProductService ms;
    @PostMapping("api/product")
    public ResponseEntity<Product>addelements(@RequestBody Product m)
    {
        Product mm=ms.create(m);
        return new ResponseEntity<>(mm,HttpStatus.CREATED);
    }
    @GetMapping("/api/products")
    public ResponseEntity<List<Product>> showinfo()
    {
        return new ResponseEntity<>(ms.getAll(),HttpStatus.OK);
    }
    @GetMapping("/api/product/{productId}")
    public ResponseEntity<Product> getById(@PathVariable Integer productId)
    {
        Product obj=ms.getMe(productId);
        return new ResponseEntity<>(obj,HttpStatus.OK);
    }
    @PutMapping("/api/product/{productId}")
    public ResponseEntity<Product> putMethodName(@PathVariable("productId") int id, @RequestBody Product m) {
        if(ms.updateDetails(id,m) == true)
        {
            return new ResponseEntity<>(m,HttpStatus.OK);
        }
        
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }
@DeleteMapping("/api/product/{productId}")
    public ResponseEntity<Boolean> delete(@PathVariable("productId") int id)
    {
        if(ms.deleteProduct(id) == true)
        {
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }

    //sorting
    @GetMapping("/product/sortBy/{field}")
    public List<Product> g(@PathVariable String field)
    {
        return ms.sort(field);
    }

    //pagination
    @GetMapping("/product/{offset}/{pagesize}")
    public List<Product> get(@PathVariable int offset,@PathVariable int pagesize)
    {
        return ms.page(pagesize, offset);
    }
    
    //sorting and pagination
    @GetMapping("/product/{offset}/{pagesize}/{field}")
    public List<Product> getsorting(@PathVariable int offset,@PathVariable int pagesize,@PathVariable String field)
    {
        return ms.getsort(offset,pagesize,field);
    }
    @GetMapping("/query/{productId}")
    public ResponseEntity<Product> findByName(@PathVariable Integer productId) 
    {
        Product sh = ms.findByName(productId);
        try{
            return new ResponseEntity<>(sh,HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(sh,HttpStatus.INTERNAL_SERVER_ERROR);
        }
}
}