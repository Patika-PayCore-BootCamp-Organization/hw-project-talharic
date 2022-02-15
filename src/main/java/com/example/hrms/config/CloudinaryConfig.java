package com.example.hrms.config;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.hrms.business.adapters.cloudinary.CloudStorageService;
import com.example.hrms.business.adapters.cloudinary.CloudinaryServiceAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudinaryConfig {

    @Bean
    public Cloudinary cloudinaryAccount() {
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "",
                "api_key", "",
                "api_secret", ""
        ));
    }

    @Bean
    public CloudStorageService cloudStorageService() {
        return new CloudinaryServiceAdapter(cloudinaryAccount());
    }

}
