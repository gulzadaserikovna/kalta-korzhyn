package com.example.demo.service;

import com.example.demo.config.MvcConfig;
import com.example.demo.data.ProductEntity;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FileService {

    private static Path getPath() {
        return MvcConfig.getPath();

    }

    public String getFileLink(MultipartFile file, ProductEntity productEntity) throws Exception {
        if (productEntity.getId() == null)
            throw new Exception("Продукт не найден");
        return saveFile(file, productEntity.getId().toString());
    }

    private String saveFile(MultipartFile file, String postLink) throws Exception {
        if (file != null) {
            Path dir = getPath().resolve(postLink);
            File uploadDir = new File(dir.toUri());
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            String uuidFile = UUID.randomUUID().toString();
            String resultFileName = uuidFile + "." + file.getOriginalFilename();
            file.transferTo(new File(dir.resolve(resultFileName).toUri()));
            return File.separator + postLink + File.separator + resultFileName;
        }
        throw new Exception("Файл пуст");
    }

    public void deleteFile(String link) {
        File file = new File(getPath() + link);
        System.out.println(file);
        file.deleteOnExit();
        if (file.isDirectory()) {
            try {
                FileUtils.deleteDirectory(file);
                System.out.println(link);
            } catch (IOException e) {
                System.out.println(link);
            }
        } else if (file.isFile()) {
            try {
                Files.delete(Paths.get(file.toURI()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
