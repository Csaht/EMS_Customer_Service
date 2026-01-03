package com.enterprise.ems.interfaces;

import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface CloudinaryImage {
    public Map upload(MultipartFile file);
}
