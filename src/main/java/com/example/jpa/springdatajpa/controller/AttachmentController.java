package com.example.jpa.springdatajpa.controller;

import com.example.jpa.springdatajpa.Response.AttachmentResponse;
import com.example.jpa.springdatajpa.entity.Attachment;
import com.example.jpa.springdatajpa.service.Impl.AttachmentService;
import org.apache.tomcat.util.file.ConfigurationSource;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Optional;


@RestController
@RequestMapping("/attachment")
public class AttachmentController {

    private AttachmentService attachmentService;

    public AttachmentController(AttachmentService attachmentService) {
        this.attachmentService = attachmentService;
    }

    @PostMapping(path = "/upload")
    public ResponseEntity<AttachmentResponse> uploadFile(@RequestParam("file")MultipartFile file) throws Exception {

        Optional<Attachment> attachment = Optional.of(Optional.ofNullable(attachmentService.saveAttachment(file)).
                orElseThrow(()->new RuntimeException("Attachment could not be saved")));

        String downloadUrl = ServletUriComponentsBuilder.fromCurrentContextPath().
                            path("/attachment/download/").
                            path(attachment.get().getId()).
                            toUriString();

        return new ResponseEntity<AttachmentResponse>(AttachmentResponse.builder().
                                            fileName(attachment.get().getFileName()).
                                            downloadUrl(downloadUrl).
                                            fileType(file.getContentType()).
                                            fileSize(file.getSize()).build(), HttpStatus.OK);
    }

    @GetMapping(path = "/download/{id}")
    public ResponseEntity<Resource> downloadFile(@PathVariable(required = true, value = "id") String id) throws Exception {

        Optional<Attachment> attachment = Optional.of(Optional.ofNullable(attachmentService.getAttachment(id)).
                orElseThrow(()->new RuntimeException("Attachment could not be saved")));

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(attachment.get().getFileType())).
                header(HttpHeaders.CONTENT_DISPOSITION,"attachment; fileName=\""+attachment.get().getFileName()+"\"").
                body(new ByteArrayResource(attachment.get().getData()));


    }



}
