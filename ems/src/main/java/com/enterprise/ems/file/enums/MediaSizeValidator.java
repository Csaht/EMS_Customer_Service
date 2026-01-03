package com.enterprise.ems.file.enums;
import org.springframework.web.multipart.MultipartFile;

public class MediaSizeValidator {

    public static void validate(MultipartFile file, MediaType type) {

        long fileSize = file.getSize();

        if (fileSize > type.getMaxSize()) {
            throw new IllegalArgumentException(
                    type.name() + " file size must be <= " +
                            (type.getMaxSize() / (1024 * 1024)) + " MB"
            );
        }
    }
}
