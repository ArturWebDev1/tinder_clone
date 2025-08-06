package com.project.tinder_clone.repositories;

import com.project.tinder_clone.domain.entities.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PhotoRepository extends JpaRepository<Photo, UUID> {
}
