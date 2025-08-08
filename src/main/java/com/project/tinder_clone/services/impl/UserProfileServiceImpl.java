package com.project.tinder_clone.services.impl;

import com.project.tinder_clone.domain.entries.UserProfile;
import com.project.tinder_clone.repositories.UserProfileRepository;
import com.project.tinder_clone.services.UserProfileService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserProfileServiceImpl implements UserProfileService {
    private final UserProfileRepository userRepo;

    @Override
    public UserProfile createProfile(UserProfile profile) {
        return userRepo.save(profile);
    }

    @Override
    public void deleteProfileById(Long id) {
        userRepo.deleteById(id);
    }

    @Override
    public UserProfile getProfileById(Long id) {
        return userRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User profile not found with id " + id));

    }

    @Transactional  // везде где больше чем один вызов репо, нужно добавлять для безопасности эту аннотацию
    @Override
    public UserProfile updateProfileById(Long id, UserProfile profile) {
        // validation
        if (null == profile.getName() || profile.getName().isBlank()) {
            throw new IllegalArgumentException("A profile must have a name!");
        }

        // Changes
        UserProfile existingProfile = userRepo.findById(id).orElseThrow(() -> {
            return new IllegalArgumentException("Task not found!");
        });

        existingProfile.setName(profile.getName());
        existingProfile.setAge(profile.getAge());
        existingProfile.setBio(profile.getBio());

        return userRepo.save(existingProfile);
    }
}
