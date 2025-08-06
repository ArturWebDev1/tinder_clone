package com.project.tinder_clone.repositories;

import com.project.tinder_clone.domain.entities.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserProfileRepository extends JpaRepository<UserProfile, UUID> {
}
