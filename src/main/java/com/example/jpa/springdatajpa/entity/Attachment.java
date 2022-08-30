package com.example.jpa.springdatajpa.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Lob;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Attachment extends CommonDataEntity{

    private String fileName;

    private String fileType;

    @Lob
    private byte[] data;
    
}
