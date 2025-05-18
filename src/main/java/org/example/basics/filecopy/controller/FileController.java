package org.example.basics.filecopy.controller;

import org.example.basics.filecopy.model.CopyRequest;
import org.example.basics.filecopy.services.FileCopyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/copy")
public class FileController {

    @Autowired
    private FileCopyService fileCopyService;

    @PostMapping("/file")
    public ResponseEntity<String> copyFile(@RequestParam CopyRequest request) {

        try{
            Path source = Paths.get(request.getSourcePath());
            Path destination = Paths.get(request.getDestinationPath());
            fileCopyService.copyFile(source, destination);
            return ResponseEntity.ok().body("File copied successfully");
        }
        catch(Exception e){
            return ResponseEntity.badRequest().body("Error while copying files: "+ e.getMessage());
        }
    }

    @PostMapping("/directory")
    public ResponseEntity<String> copyDirectory(@RequestParam CopyRequest request) {

        try{
            Path source = Paths.get(request.getSourcePath());
            Path destination = Paths.get(request.getDestinationPath());
            fileCopyService.copyDirectory(source,destination);
            return ResponseEntity.ok().body("Directory copied successfully");
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body("Error while copying directory: "+e.getMessage());
        }
    }




}
