package com.project.tinder_clone.controllers;

import com.project.tinder_clone.domain.entries.UserProfile;
import com.project.tinder_clone.services.UserProfileService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/profiles")
@RequiredArgsConstructor
public class UserProfileController {
    private final UserProfileService service;

    @PostMapping
    public ResponseEntity<UserProfile> create(@RequestBody @Valid UserProfile profile) {
        UserProfile saved = service.createProfile(profile);
        return ResponseEntity.ok(saved);
    }
}
