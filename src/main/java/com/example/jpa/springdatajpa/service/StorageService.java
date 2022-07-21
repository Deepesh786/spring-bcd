package com.example.jpa.springdatajpa.service;

import com.example.jpa.springdatajpa.Storageimpl.StorageB;
import com.example.jpa.springdatajpa.implementaions.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class StorageService {


    @Autowired
    @Qualifier(value = "StorageA")
    public Storage storage;


    public String qualifierTest(String str){
        return storage.show(str);
    }


}
