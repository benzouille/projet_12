package fr.banane.newsservice.news.services;

import fr.banane.newsservice.news.config.Constants;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class StorageServiceImpl implements StorageService{

    private Path uploadLocation;

    @PostConstruct
    public void init() {
        this.uploadLocation = Paths.get(Constants.UPLOAD_LOCATION);
        try {
            Files.createDirectories(uploadLocation);
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize storage", e);
        }
    }

    @Override
    public void store(MultipartFile file) {
        String filename = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            if (file.isEmpty()) {
                throw new RuntimeException("Failed to store empty file " + filename);
            }

            // This is a security check
            if (filename.contains("..")) {
                throw new RuntimeException("Cannot store file with relative path outside current directory " + filename);
            }

            try (InputStream inputStream = file.getInputStream()) {
                Files.copy(inputStream, this.uploadLocation.resolve(filename), StandardCopyOption.REPLACE_EXISTING);
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to store file " + filename, e);
        }
    }

    @Override
    public Resource loadAsResource(String filename) {
        try {
            Path file = uploadLocation.resolve(filename);
            System.out.println("path : "+file.toString());
            Resource resource = new UrlResource(file.toUri());
            System.out.println("resource : "+resource.toString());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Could not read file: " + filename);
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Could not read file: " + filename, e);
        }
    }

    public File loadAsPath(String filename) {
        Path path = uploadLocation.resolve(filename);
        File file = path.toFile();
        if (file != null) {
            return file;
        } else {
            throw new RuntimeException("Could not read file: " + filename);
        }
    }

    @Override
    public Path getUploadLocation() {
        return uploadLocation;
    }
}
