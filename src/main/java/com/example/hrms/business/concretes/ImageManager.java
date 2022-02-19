package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.ImageService;
import com.example.hrms.business.abstracts.UserService;
import com.example.hrms.business.adapters.cloudinary.CloudStorageService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.ImageDao;
import com.example.hrms.entities.concretes.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@Service
public class ImageManager implements ImageService {

    private ImageDao imageDao;
    private CloudStorageService cloudStorageService;
    private UserService userService;

    @Autowired
    public ImageManager(ImageDao imageDao, CloudStorageService cloudStorageService, UserService userService) {
        this.imageDao = imageDao;
        this.cloudStorageService = cloudStorageService;
        this.userService = userService;
    }

    @Override
    public Result add(Image image) {

        imageDao.save(image);
        return new SuccessResult("İmaj eklendi.");
    }

    @Override
    public Result update(Image image) {

        imageDao.save(image);
        return new SuccessResult("İmaj güncellendi.");
    }

    @Override
    public Result delete(int id) {

        Image image = getById(id).getData();

        String[] splitImageUrlArray = image.getUrl().split("/");
        int indexOfExtension = splitImageUrlArray[splitImageUrlArray.length - 1].indexOf(".");
        String publicIdOfImage = splitImageUrlArray[splitImageUrlArray.length - 1].substring(0, indexOfExtension);

        cloudStorageService.delete(publicIdOfImage);
        imageDao.deleteById(id);
        return new SuccessResult("İmaj silindi.");
    }

    @Override
    public DataResult<List<Image>> getAll() {
        return new SuccessDataResult<List<Image>>(imageDao.findAll());
    }

    @Override
    public DataResult<Image> getById(int id) {
        return new SuccessDataResult<Image>(imageDao.getById(id));
    }

    @Override
    public Result upload(int userId, MultipartFile file) {

        Map<?, ?> uploadImage = (Map<?, ?>) cloudStorageService.upload(file).getData();

        Image image = new Image();
        image.setUser(userService.getById(userId).getData());
        image.setUrl(uploadImage.get("url").toString());

        return add(image);
    }

    @Override
    public DataResult<Image> getByUserId(int userId) {
        return new SuccessDataResult<Image>(imageDao.getByUser_Id(userId));
    }

}
