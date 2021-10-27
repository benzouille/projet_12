package fr.banane.newsservice.news.web.controller;

import fr.banane.newsservice.news.services.StorageService;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@Controller
public class FileController {

    StorageService storageService;

    public FileController(StorageService storageService) {
        this.storageService = storageService;
    }

    //-----------------------------IMG-----------------------------

    /**
     * Endpoint renvoyant un lien vers une image
     * @param filename string
     * @return ResponseEntity
     */
    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
                .body(file);
    }

    /**
     * Endpoint permetant de télécharger un fichier {@link MultipartFile}
     * @param file MultipartFile
     * @return ResponseEntity
     */
    @PostMapping("/files/upload")
    public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {
        System.out.println("message : You successfully uploaded " + file.getOriginalFilename() + "!");
        storageService.store(file);
        return new ResponseEntity(file.getContentType(), HttpStatus.OK);
    }

    /**
     * Endpoint renvoyant une image
     * @param filename string
     * @return ResponseEntity
     */
    @RequestMapping("/image/{filename:.+}")
    @ResponseBody
    public HttpEntity<byte[]> getPhoto(@PathVariable String filename) throws IOException {
        byte[] image = org.apache.commons.io.FileUtils.readFileToByteArray(storageService.loadAsPath(filename));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);
        headers.setContentLength(image.length);
        return new HttpEntity<byte[]>(image, headers);
    }
}
