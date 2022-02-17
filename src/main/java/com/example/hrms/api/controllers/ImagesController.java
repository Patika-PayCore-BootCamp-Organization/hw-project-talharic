package com.example.hrms.api.controllers;

import com.example.hrms.business.abstracts.ImageService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/images")
@CrossOrigin
public class ImagesController {

    private ImageService imageService;

    @Autowired
    public ImagesController(ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody Image image) {
        return imageService.delete(image);
    }

    @GetMapping("/getAll")
    public DataResult<List<Image>> getAll() {
        return imageService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<Image> getById(@RequestParam int id) {
        return imageService.getById(id);
    }

    @PostMapping("/upload")
    public Result upload(@RequestParam int userId, @RequestParam MultipartFile file) {
        return imageService.upload(userId, file);
    }

    @GetMapping("/getByUserId")
    public DataResult<Image> getByUserId(@RequestParam int userId) {
        return imageService.getById(userId);
    }

}
