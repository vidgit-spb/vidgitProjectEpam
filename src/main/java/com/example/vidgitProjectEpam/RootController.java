package com.example.vidgitProjectEpam;

import com.example.vidgitProjectEpam.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.util.List;

@Controller
public class RootController {

    @Autowired
    private FileService fileService;

    @GetMapping("/")
    public String greeting(@RequestParam(name = "path", required = false, defaultValue = "D:\\") String path, Model model) {
        String delimeter = "\\";
        List<File> textFiles = fileService.getTextFiles(path);
        List<File> notTextFiles = fileService.getNotTextFiles(path);
        List<File> directories = fileService.getDirectoryFiles(path);

        model.addAttribute("textFiles", fileService.getNamesFromFiles(textFiles));
        model.addAttribute("notTextFiles", fileService.getNamesFromFiles(notTextFiles));
        model.addAttribute("directories", fileService.getNamesFromFiles(directories));
        model.addAttribute("path", path);
        model.addAttribute("delimeter", delimeter);
        return "main";
    }



}