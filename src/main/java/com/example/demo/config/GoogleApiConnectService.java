package com.example.demo.config;

import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.FileList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

@Service
public class GoogleApiConnectService {

    @Autowired
    private Drive driver;

    public List<com.google.api.services.drive.model.File> getAllGoogleDriveFiles() throws IOException {
        FileList result = driver.files().list()
                .setFields("nextPageToken, files(id, name, parents, mimeType)")
                .execute();
        return result.getFiles();
    }

    public String createNewFolder(String folderName) throws IOException {
        com.google.api.services.drive.model.File fileMetadata = new com.google.api.services.drive.model.File();
        fileMetadata.setName(folderName);
        fileMetadata.setMimeType("application/vnd.google-apps.folder");

        String parentFolderId = "1jJ2HeMUN1v0riiEt9LMuhteFUuQg7SFg";
        fileMetadata.setParents(Collections.singletonList(parentFolderId));

        com.google.api.services.drive.model.File file = driver.files().create(fileMetadata).setFields("id").execute();
        return file.getId();
    }

}
