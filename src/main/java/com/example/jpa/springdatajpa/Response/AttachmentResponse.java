package com.example.jpa.springdatajpa.Response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AttachmentResponse {

    private String fileName;
    private String downloadUrl;
    private String fileType;
    private long fileSize;
}
