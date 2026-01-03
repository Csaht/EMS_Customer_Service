package com.enterprise.ems.controllers;

import com.enterprise.ems.services.MediaUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class UploadController {

  /*  @Autowired
    private MediaUploadService mediaUploadService;
    @PostMapping("/upload-single")
    public ResponseEntity<String> uploadSingle(
            @RequestParam("image") MultipartFile image) {

        // 1. Check if image exists
        if (image.isEmpty()) {
            return ResponseEntity.badRequest().body("No image selected");
        }

        // 2. Validate image type
        if (!image.getContentType().startsWith("image/")) {
            return ResponseEntity.badRequest().body("Only images allowed");
        }

        // 3. Get image info
        String fileName = image.getOriginalFilename();
        long size = image.getSize();

        // 4. Save image (later)
        // image.getBytes()

        return ResponseEntity.ok(
                "Uploaded image: " + fileName + " (" + size + " bytes)"
        );
    }

    @PostMapping("/upload-multiple")
    public ResponseEntity<String> uploadMultiple(
            @RequestParam("images") List<MultipartFile> images) {

        if (images.isEmpty()) {
            return ResponseEntity.badRequest().body("No images selected");
        }

        for (MultipartFile image : images) {
            if (!image.isEmpty()) {
                // Validate
                if (!image.getContentType().startsWith("image/")) {
                    return ResponseEntity.badRequest()
                            .body("Only images allowed");
                }

                // Process image
                String fileName = image.getOriginalFilename();
                // Save image
            }
        }

        return ResponseEntity.ok("Uploaded " + images.size() + " images");
    }

   *//* ***************************//*
   @PostMapping("/upload/media")
   public ResponseEntity<String> uploadSingleMedia(
           @RequestParam("file") MultipartFile file) {

       String url = mediaUploadService.uploadSingle(file);
       return ResponseEntity.ok(url);
   }


    @PostMapping("/upload/media/multiple")
    public ResponseEntity<List<String>> uploadMultipleMedia(
            @RequestParam("files") List<MultipartFile> files) {

        List<String> urls = mediaUploadService.uploadMultiple(files);
        return ResponseEntity.ok(urls);
    }*/
}
