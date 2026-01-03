package com.enterprise.ems.config;

/*public class CloudinaryConfig {
}*/

import com.cloudinary.Cloudinary;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.modelmapper.ModelMapper;
import java.util.HashMap;
import java.util.Map;
/*

@Configuration
public class CloudinaryConfig {



    @Bean
    public ModelMapper mapper() {
        return new ModelMapper();
    }


    @Bean
    public Cloudinary getCloudinary() {
       */
/* Map<String, Object> config = new HashMap<>();*//*

        Map config = new HashMap<>();
        config.put("cloud_name", cloudName);
        config.put("api_key", apiKey);
        config.put("api_secret", apiSecret);
        return new Cloudinary(config);
    }
}
*/

@Configuration
public class CloudinaryConfig {

    // ---------- ModelMapper ----------
    @Bean
    public ModelMapper mapper() {
        return new ModelMapper();
    }

    // ---------- Values from application.yml ----------
  /*  @Value("${cloudinary.cloud-name}")
    private String cloudName;

    @Value("${cloudinary.api-key}")
    private String apiKey;

    @Value("${cloudinary.api-secret}")
    private String apiSecret;*/

    // ---------- Cloudinary ----------
    @Bean
    public Cloudinary cloudinary() {
        Map<String, Object> config = new HashMap<>();
       /* config.put("cloud_name", cloudName);
        config.put("api_key", apiKey);
        config.put("api_secret", apiSecret);*/



        config.put("cloud_name", "dz8fvgbrs");
        config.put("api_key", "189877976637468");
        config.put("api_secret", "qxWVu4CRG_074jCvJcY_NlIWPoY");
        return new Cloudinary(config);
    }
}


