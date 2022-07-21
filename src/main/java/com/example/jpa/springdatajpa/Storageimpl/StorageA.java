package com.example.jpa.springdatajpa.Storageimpl;

import com.example.jpa.springdatajpa.implementaions.Storage;
import org.springframework.stereotype.Component;

@Component("StorageA")
public class StorageA implements Storage {

    @Override
    public String show(String str) {
        return str+"StorageA";
    }
}
