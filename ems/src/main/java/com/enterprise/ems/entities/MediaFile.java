package com.enterprise.ems.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="media_file")
public class MediaFile {

    @Id
    @GeneratedValue
    private Long id;

    private String url;
    private String mediaType; // AUDIO / VIDEO
}
