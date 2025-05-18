package org.example.basics.filecopy.services;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

@Service
public class FileCopyService {

    public void copyFile(Path source, Path destination) throws IOException {
        if(Files.isDirectory(source)) {
            throw new IOException("Source is a directory. Use Directory endpoint");
        }
        Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
    }

    public void copyDirectory(Path source, Path destination) throws IOException {
        if(!Files.isDirectory(source)) {
            Files.createDirectories(destination);
        }

        Files.walkFileTree(source,new SimpleFileVisitor<Path>() {

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                Path targetFile = destination.resolve(source.relativize(file));
                Files.copy(file, targetFile, StandardCopyOption.REPLACE_EXISTING);
                return FileVisitResult.CONTINUE;
            }

           // @Override
            public FileVisitResult visitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                Path targetDir = destination.resolve(source.relativize(dir));
                if (Files.notExists(targetDir)) {
                    Files.createDirectories(targetDir);
                }
                return FileVisitResult.CONTINUE;
            }
        });
    }

}
