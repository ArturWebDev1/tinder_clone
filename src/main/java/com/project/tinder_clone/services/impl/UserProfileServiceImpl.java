package com.project.tinder_clone.services.impl;

import com.project.tinder_clone.domain.entries.UserProfile;
import com.project.tinder_clone.repositories.UserProfileRepository;
import com.project.tinder_clone.services.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserProfileServiceImpl implements UserProfileService {
    private final UserProfileRepository userRepo;

    @Override
    public UserProfile createProfile(UserProfile profile) {
        return userRepo.save(profile);
    }
}
