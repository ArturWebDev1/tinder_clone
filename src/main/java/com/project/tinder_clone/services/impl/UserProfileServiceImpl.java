package com.project.tinder_clone.services.impl;

import com.project.tinder_clone.domain.entities.Photo;
import com.project.tinder_clone.domain.entities.UserProfile;
import com.project.tinder_clone.repositories.PhotoRepository;
import com.project.tinder_clone.repositories.UserProfileRepository;
import com.project.tinder_clone.services.FileStorageService;
import com.project.tinder_clone.services.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserProfileServiceImpl implements UserProfileService {

    private final UserProfileRepository userRepo;
    private final PhotoRepository photoRepo;
    private final FileStorageService storage;

    @Override
    public UserProfile createProfile(UserProfile profile, MultipartFile[] photos) {
        UserProfile saved = userRepo.save(profile);

        List<Photo> photoEntities = Arrays.stream(photos)
                .map(file -> {
                    String fname = storage.store(file);
                    Photo p = Photo.builder()
                            .filename(fname)
                            .url("/uploads/" + fname)
                            .profile(saved)
                            .build();
                    return photoRepo.save(p);
                })
                .collect(Collectors.toList());

        saved.setPhotos(photoEntities);
        return saved;
    }
}
