package com.example.demo.config;

import com.google.api.services.drive.model.File;
import com.google.common.io.Files;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
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

    @PostMapping(value = "/google-drive/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String upload(@RequestBody MultipartFile image) {
        try {
            return googleDriveService.uploadImage(image);
        } catch (IOException e) {
            throw new RuntimeException("Error creating folder on Google Drive.", e);
        }
    }

   /* @GetMapping("/from-drive")
    public ResponseEntity<String> downloadFileFromGoogleDrive(@RequestParam String urL, @RequestParam String saveFolder) {
        try {
            this.googleDriveService.downloadFileFromURL(urL, saveFolder);
            return new ResponseEntity<>("File downloaded successfully!", HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error downloading the file.", HttpStatus.INTERNAL_SERVER_ERROR);

        }*/

    @GetMapping("/download")
    public ResponseEntity<String> downloadImage(
            @RequestParam String fileId
    ) {
        try {
            // Specify the root directory
            String rootPath = "D:\\";
            String folderName = "image";

            // Tạo đường dẫn cho thư mục 'image' trong ổ đĩa D:
            Path directory = Paths.get(rootPath, folderName);

            // Check if the directory exists, and create it if not
            if (!java.nio.file.Files.exists(directory)) {
                java.nio.file.Files.createDirectory(directory);
            }

            // Call the download method, which returns the saved file path
            Path savedFilePath = googleDriveService.downloadImageAndReturnLink(fileId, directory);

            if (savedFilePath != null) {
                // Trả về thông báo thành công
                return ResponseEntity.ok("Tải xuống và lưu trữ tệp ảnh thành công.");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Lỗi khi tải xuống tệp ảnh.");
            }
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Lỗi khi tải xuống tệp ảnh.");
        }
    }


}