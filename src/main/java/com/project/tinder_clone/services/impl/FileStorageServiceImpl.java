package com.project.tinder_clone.services.impl;


import com.google.cloud.storage.Blob;
import com.google.firebase.cloud.StorageClient;
import com.project.tinder_clone.repositories.UserProfileRepository;
import com.project.tinder_clone.services.FileStorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.net.URL;
import java.util.concurrent.TimeUnit;


@Service
@RequiredArgsConstructor
public class FileStorageServiceImpl implements FileStorageService {
    private final UserProfileRepository photoRepo;


    @Override
    public String store(MultipartFile file) {
        return "oguzok";
//        try {
//            // 1. Название файла — например, user123/profile.jpg
//            String fileName = "profiles/" + file.getOriginalFilename();
//
//            // 2. Загрузка в Firebase Storage
//            Blob blob = StorageClient.getInstance().bucket()
//                    .create(fileName, file.getBytes(), file.getContentType());
//
//            // 3. Генерация временной ссылки (например, на 1 час)
//            URL signedUrl = blob.signUrl(1, TimeUnit.HOURS);
//
//            // 4. Верни URL клиенту (и можешь сохранить его в БД)
//            return signedUrl.toString();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            return "Ошибка загрузки фото: " + e.getMessage();
//        }
    }
}
