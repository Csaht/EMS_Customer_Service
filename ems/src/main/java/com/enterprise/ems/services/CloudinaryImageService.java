package com.enterprise.ems.services;

import com.cloudinary.Cloudinary;
import com.enterprise.ems.interfaces.CloudinaryImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@Service
public class CloudinaryImageService implements CloudinaryImage {
    @Autowired
    private Cloudinary cloudinary;

    @Override
    public Map upload(MultipartFile file){
        try {
         Map data =   this.cloudinary.uploader().upload(file.getBytes(),Map.of());
         return  data;
        } catch (Exception e) {
            throw new RuntimeException("Image Uploading Fail");
        }

    }
}
