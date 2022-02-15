package com.example.hrms.business.abstracts;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Image;
import org.springframework.web.multipart.MultipartFile;

public interface ImageService extends BaseEntityService<Image> {

    Result upload(int userId, MultipartFile file);

    DataResult<Image> getByUserId(int userId);

}
