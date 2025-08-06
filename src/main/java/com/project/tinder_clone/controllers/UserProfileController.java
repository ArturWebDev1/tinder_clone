package com.project.tinder_clone.controllers;

import com.project.tinder_clone.domain.entities.UserProfile;
import com.project.tinder_clone.services.impl.UserProfileServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/profiles")
@RequiredArgsConstructor
public class UserProfileController {

    private final UserProfileServiceImpl userProfileService;

    @PostMapping(consumes = { "multipart/form-data" })
    public ResponseEntity<UserProfile> create(
            @RequestPart("data") @Valid UserProfile profile,
            @RequestPart("photos") MultipartFile[] photos) {
        UserProfile result = userProfileService.createProfile(profile, photos);
        return ResponseEntity.ok(result);
    }
}
