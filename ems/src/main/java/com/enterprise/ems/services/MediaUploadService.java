package com.enterprise.ems.services;
import com.enterprise.ems.file.enums.MediaSizeValidator;
import com.enterprise.ems.file.enums.MediaType;
import com.enterprise.ems.file.enums.MediaTypeDetector;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class MediaUploadService {



   /* public MediaUploadService(Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
    }

    public String uploadSingle(MultipartFile file) {

        MediaType type = MediaTypeDetector.detect(file);
        MediaSizeValidator.validate(file, type);

        try {
            Map result = cloudinary.uploader().upload(
                    file.getBytes(),
                    Map.of(
                            "resource_type", "video",
                            "folder", type == MediaType.AUDIO ? "audios" : "videos"
                    )
            );

            return result.get("secure_url").toString();

        } catch (Exception e) {
            throw new RuntimeException("Media upload failed");
        }
    }

    public List<String> uploadMultiple(List<MultipartFile> files) {

        List<String> urls = new ArrayList<>();

        for (MultipartFile file : files) {
            urls.add(uploadSingle(file)); // reuse logic
        }

        return urls;
    }*/
}

