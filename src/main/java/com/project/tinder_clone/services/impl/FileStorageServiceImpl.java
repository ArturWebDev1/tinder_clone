package com.project.tinder_clone.services.impl;

import com.project.tinder_clone.services.FileStorageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Optional;
import java.util.UUID;

@Service
public class FileStorageServiceImpl implements FileStorageService {

    private final Path rootLocation;

    public FileStorageServiceImpl(@Value("${file.upload-dir}") String dir) {
        this.rootLocation = Paths.get(dir);
        try { Files.createDirectories(rootLocation); }
        catch (IOException e) { throw new RuntimeException("Could not create upload dir", e); }
    }

    @Override
    public String store(MultipartFile file) {
        String ext = Optional.ofNullable(file.getOriginalFilename())
                .filter(n -> n.contains("."))
                .map(n -> n.substring(n.lastIndexOf('.')))
                .orElse("");
        String filename = UUID.randomUUID() + ext;
        try {
            Files.copy(file.getInputStream(), rootLocation.resolve(filename),
                    StandardCopyOption.REPLACE_EXISTING);
            return filename;
        } catch (IOException e) {
            throw new RuntimeException("Failed to store file", e);
        }
    }
}
