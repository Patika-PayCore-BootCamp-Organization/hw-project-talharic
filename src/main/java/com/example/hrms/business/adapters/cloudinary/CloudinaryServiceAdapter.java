package com.example.hrms.business.adapters.cloudinary;

import java.io.IOException;
import java.util.Map;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.ErrorDataResult;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
public class CloudinaryServiceAdapter implements CloudStorageService {

    private Cloudinary cloudinary;

    @Autowired
    public CloudinaryServiceAdapter() {
        cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "",
                "api_key", "",
                "api_secret", ""));
    }

    @Override
    public DataResult<?> upload(MultipartFile multipartFile) {

        try {
            Map<?, ?> uploadResult = cloudinary.uploader().upload(multipartFile.getBytes(), ObjectUtils.emptyMap());
            return new SuccessDataResult<>(uploadResult);
        } catch (IOException e) {
            e.printStackTrace();
            return new ErrorDataResult<>();
        }
    }

}
