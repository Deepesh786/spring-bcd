package com.example.jpa.springdatajpa.Storageimpl;

import com.example.jpa.springdatajpa.implementaions.Storage;
import org.springframework.stereotype.Component;

@Component("StorageB")
public class StorageB implements Storage {
    @Override
    public String show(String str) {
        return str+"StorageB";
    }
}
