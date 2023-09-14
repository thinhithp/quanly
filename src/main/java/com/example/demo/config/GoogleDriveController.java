package com.example.demo.config;

import com.google.api.services.drive.model.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class GoogleDriveController {

    @Autowired
    private GoogleApiConnectService googleDriveService;

    @GetMapping("/google-drive/files")
    public List<File> getAllGoogleDriveFiles() {
        try {
            return googleDriveService.getAllGoogleDriveFiles();
        } catch (IOException e) {
            throw new RuntimeException("Error fetching Google Drive files.", e);
        }
    }

    @GetMapping("/google-drive/create-folder")
    public String createNewFolder(@RequestParam String folderName) {
        try {
            return googleDriveService.createNewFolder(folderName);
        } catch (IOException e) {
            throw new RuntimeException("Error creating folder on Google Drive.", e);
        }
    }
}