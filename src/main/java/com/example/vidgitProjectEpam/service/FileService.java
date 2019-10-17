package com.example.vidgitProjectEpam.service;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileService {

    public List<String> getNamesFromFiles(List <File> listFileNames) {
        List <String> listStringFileNames = new ArrayList<>();
        for(File file:listFileNames){
            listStringFileNames.add(file.getName());
        }
        return listStringFileNames;

    }
    public List<File> getTextFiles(String directoryPath) {
        File path = new File(directoryPath);
        List<File> listTextFiles = new ArrayList<>();

        for (File file : path.listFiles()) {
            if (file.isFile() && "txt".equals(FilenameUtils.getExtension(file.getAbsolutePath()))) {
                listTextFiles.add(file);
            }
        }

        return listTextFiles;
    }

    public List<File> getDirectoryFiles(String directoryPath) {
        File path = new File(directoryPath);
        List<File> listDirectory = new ArrayList<>();
        for (File file : path.listFiles()) {
            if (file.isDirectory()) {
                listDirectory.add(file);
            }
        }
        return listDirectory;
    }

    public List<File> getNotTextFiles(String directoryPath) {
        File path = new File(directoryPath);
        List<File> listNotTextFiles = new ArrayList<>();

        for (File file : path.listFiles()) {
            if (file.isFile() && !"txt".equals(FilenameUtils.getExtension(file.getAbsolutePath()))) {
                listNotTextFiles.add(file);
            }
        }

        return listNotTextFiles;
    }
}
