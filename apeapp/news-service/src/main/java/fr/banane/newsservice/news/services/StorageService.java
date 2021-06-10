package fr.banane.newsservice.news.services;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Path;

public interface StorageService {

    void store(MultipartFile multipart);
    Resource loadAsResource(String filename);

    Path getUploadLocation();

    File loadAsPath(String filename);
}
