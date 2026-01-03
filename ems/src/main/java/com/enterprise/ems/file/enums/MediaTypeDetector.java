package com.enterprise.ems.file.enums;
import org.springframework.web.multipart.MultipartFile;

public class MediaTypeDetector {

    public static MediaType detect(MultipartFile file) {

        String contentType = file.getContentType();

        if (contentType == null) {
            throw new IllegalArgumentException("Invalid file type");
        }

        if (contentType.startsWith("audio/")) {
            return MediaType.AUDIO;
        }

        if (contentType.startsWith("video/")) {
            return MediaType.VIDEO;
        }

        throw new IllegalArgumentException("Only audio or video allowed");
    }
}

