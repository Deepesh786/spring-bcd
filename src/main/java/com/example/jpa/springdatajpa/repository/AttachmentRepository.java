package com.example.jpa.springdatajpa.repository;


import com.example.jpa.springdatajpa.entity.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttachmentRepository extends JpaRepository<Attachment,String> {

}