package com.example.jpa.springdatajpa.service.Impl;

import com.example.jpa.springdatajpa.entity.Attachment;
import com.example.jpa.springdatajpa.repository.AttachmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class AttachmentService {

    private AttachmentRepository attachmentRepository;

    @Autowired
    public AttachmentService(AttachmentRepository attachmentRepository) {
        this.attachmentRepository = attachmentRepository;
    }

    public Attachment saveAttachment(MultipartFile multipartFile) throws Exception {

        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        try {
            if (fileName.contains("..")) {
                throw new Exception(" Inavalid file path sequence" + fileName);
            }
            Attachment attachment = Attachment.
                    builder().
                    fileName(fileName).
                    fileType(multipartFile.getContentType()).
                    data(multipartFile.getBytes()).
                    build();
            return attachmentRepository.save(attachment);

        } catch (Exception e) {
            throw new Exception("Could not save file " + fileName);
        }
    }

    public Attachment getAttachment(String id) throws Exception {

        return attachmentRepository.findById(id).orElseThrow(()->new Exception("Could not find attachment "+id));
    }





}
