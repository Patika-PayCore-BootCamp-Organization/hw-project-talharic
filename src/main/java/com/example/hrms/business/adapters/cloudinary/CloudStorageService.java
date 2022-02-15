package com.example.hrms.business.adapters.cloudinary;

import com.example.hrms.core.utilities.results.DataResult;
import org.springframework.web.multipart.MultipartFile;

public interface CloudStorageService {

    DataResult<?> upload(MultipartFile multipartFile);

    DataResult<?> delete(String publicIdOfImage);

}
