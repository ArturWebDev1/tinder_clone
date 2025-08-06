package com.project.tinder_clone.services.impl;

import com.project.tinder_clone.domain.entries.UserProfile;
import com.project.tinder_clone.repositories.UserProfileRepository;
import com.project.tinder_clone.services.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
      
    @Override
    public UserProfile getProfileById(long id) {
        return userRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User profile not found with id " + id));

    }
}
