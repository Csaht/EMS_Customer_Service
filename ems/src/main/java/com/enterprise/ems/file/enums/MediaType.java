package com.enterprise.ems.file.enums;

public enum MediaType {
    AUDIO(2 * 1024 * 1024),   // 2 MB
    VIDEO(10 * 1024 * 1024);  // 10 MB

    private final long maxSize;

    MediaType(long maxSize) {
        this.maxSize = maxSize;
    }

    public long getMaxSize() {
        return maxSize;
    }
}
