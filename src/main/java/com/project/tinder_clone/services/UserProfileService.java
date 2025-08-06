package com.project.tinder_clone.services;

import com.project.tinder_clone.domain.entities.UserProfile;
import org.springframework.web.multipart.MultipartFile;

public interface UserProfileService {
    UserProfile createProfile(UserProfile profile, MultipartFile[] photos);
}
