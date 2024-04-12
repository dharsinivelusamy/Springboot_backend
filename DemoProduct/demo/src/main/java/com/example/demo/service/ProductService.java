package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepo;

@Service
public class ProductService {
    @Autowired
    ProductRepo mr;
    public Product create (Product mm)
    {
        return mr.save(mm);
    }
    public List<Product> getAll()
    {
        return mr.findAll();
    }
    public Product getMe(int id)
    {
        return mr.findById(id).orElse(null);
    }
    public boolean updateDetails(int id,Product mm)
        {
            if(this.getMe(id)==null)
            {
                return false;
            }
            try{
                mr.save(mm);
            }
            catch(Exception e)
            {
                return false;
            }
            return true;
        }
public boolean deleteProduct(int id)
        {
            if(this.getMe(id) == null)
            {
                return false;
            }
            mr.deleteById(id);
            return true;
        }



        //sorting by field
    
    public List<Product> sort(String field)
    {
        Sort sort=Sort.by(Sort.Direction.ASC,field);
        return mr.findAll(sort);     
    }
    //pagination
    
    public List<Product> page(int pageSize,int pageNumber)
    {
        Pageable page=PageRequest.of(pageNumber,pageSize);
        return mr.findAll(page).getContent();
    }
    //sorting and pagination
    
    public List<Product> getsort(int pageNumber,int pageSize,String field)
    {
        return mr.findAll(PageRequest.of(pageNumber, pageSize)
        .withSort(Sort.by(Sort.Direction.ASC,field))).getContent();
    }
    public Product findByName(Integer productId) {
        return mr.findByName(productId);
    }
}
