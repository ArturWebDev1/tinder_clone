package com.project.tinder_clone.domain.entries.photos;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.IOException;

@Configuration
public class FirebaseConfig {

//    @Value("${firebase.credentials.path}")
//    private String firebaseConfigPath;
//
//    @Value("${firebase.bucket.name}")
//    private String firebaseBucket;
//
//    @PostConstruct
//    public void initializeFirebase() {
//        try {
//            FileInputStream serviceAccount = new FileInputStream(firebaseConfigPath);
//
//            FirebaseOptions options = FirebaseOptions.builder()
//                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
//                    .setStorageBucket(firebaseBucket)
//                    .build();
//
//            if (FirebaseApp.getApps().isEmpty()) {
//                FirebaseApp.initializeApp(options);
//                System.out.println("✅ Firebase initialized successfully");
//            } else {
//                System.out.println("⚠️ Firebase already initialized");
//            }
//
//        } catch (IOException e) {
//            System.err.println("❌ Failed to initialize Firebase: " + e.getMessage());
//        }
//    }
}
