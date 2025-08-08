package com.project.tinder_clone.controllers;


import com.project.tinder_clone.services.FileStorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/api/photos")
@RequiredArgsConstructor
public class PhotoController {

    private final FileStorageService photoService;

    @PostMapping("/upload")
    public String uploadPhoto(@RequestParam("file") MultipartFile file) {
        return photoService.store(file);
    }
}