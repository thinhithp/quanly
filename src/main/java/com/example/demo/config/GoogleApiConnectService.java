package com.example.demo.config;

import com.google.api.client.http.FileContent;
import com.google.api.client.http.GenericUrl;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.FileList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Path;
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

        String parentFolderId = "1Ykt7ksHaucwB_i-ez0QCA3SVeeS_gv5U";
        fileMetadata.setParents(Collections.singletonList(parentFolderId));

        com.google.api.services.drive.model.File file = driver.files().create(fileMetadata).setFields("id").execute();
        return file.getId();
    }

    public String uploadImage(MultipartFile imageFile) throws IOException {
        // Chuyển đổi MultipartFile thành java.io.File
        File localFile = convertMultipartFileToFile(imageFile);

        com.google.api.services.drive.model.File fileMetadata = new com.google.api.services.drive.model.File();
        fileMetadata.setName(localFile.getName());
        String parentFolder = "1n38aIqPBZhyUAfMFFrBtd3RBW5T7NvwA";
        fileMetadata.setParents(Collections.singletonList(parentFolder));
        FileContent fileContent = new FileContent("image/jpeg", localFile);
        com.google.api.services.drive.model.File uploadFile = this.driver.files().create(fileMetadata, fileContent)
                .setFields("id")
                .execute();

        // Tạo đường dẫn xem trước
        String fileId = uploadFile.getId();
        String previewLink = "https://drive.google.com/file/d/" + fileId + "/view";

        return previewLink;
    }

    private File convertMultipartFileToFile(MultipartFile multipartFile) throws IOException {
        // Tạo một tệp tạm thời
        File file = File.createTempFile("temp-", multipartFile.getOriginalFilename());
        multipartFile.transferTo(file);
        return file;
    }

   /* public void downloadFileFromURL(String fileURL, String saveDir) throws IOException {
        URL url = new URL(fileURL);
        String fileName = new File(url.getPath()).getName();
        Path destinationPath = Paths.get(saveDir, fileName);

        try (InputStream in = url.openStream()) {
            Files.copy(in, destinationPath, StandardCopyOption.REPLACE_EXISTING);
        }
    }*/
   /*public ResponseEntity<byte[]> downloadImage(String fileId) {
       try {
           // Yêu cầu Drive API trả về nội dung của tệp
           ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
           this.driver.files().get(fileId).executeMediaAndDownloadTo(outputStream);

           // Chuyển đổi dữ liệu đã tải về thành mảng byte
           byte[] imageBytes = outputStream.toByteArray();

           // Xây dựng phản hồi HTTP để tải xuống ảnh
           HttpHeaders headers = new HttpHeaders();
           headers.setContentType(MediaType.IMAGE_JPEG); // Định dạng của tệp ảnh
           headers.setContentDispositionFormData("attachment", fileId + ".jpg"); // Tên tệp khi tải xuống

           return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);
       } catch (IOException e) {
           e.printStackTrace();
           return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
       }
   }*/

    public Path downloadImageAndReturnLink(String folderId, Path savePath) throws IOException {
        // Tìm tất cả các tệp trong thư mục với folderId
        String query = "'" + folderId + "' in parents";
        FileList fileList = this.driver.files().list().setQ(query).execute();

        if (fileList.getFiles().isEmpty()) {
            throw new IOException("Thư mục không chứa tệp hình ảnh.");
        }

        // Lấy tệp đầu tiên từ danh sách tệp trong thư mục
        com.google.api.services.drive.model.File uploadedFile = fileList.getFiles().get(0);

        // Kiểm tra xem tệp đã tải lên có đúng là một tệp không
        if (!uploadedFile.getMimeType().equals("image/jpeg")) {
            throw new IOException("Không thể tải xuống tệp vì không phải là hình ảnh JPEG.");
        }

        // Lấy đường dẫn tải xuống từ thông tin tệp
        String downloadLink = uploadedFile.getWebContentLink();

        // Thực hiện tải xuống tệp và lưu vào thư mục đã chỉ định
        try (OutputStream outputStream = new FileOutputStream(String.valueOf(savePath))) {
            this.driver.getRequestFactory().buildGetRequest(new GenericUrl(downloadLink)).execute().download(outputStream);
        }

        return savePath;
    }

}
