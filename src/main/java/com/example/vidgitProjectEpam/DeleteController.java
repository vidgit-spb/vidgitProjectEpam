package com.example.vidgitProjectEpam;


import com.example.vidgitProjectEpam.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DeleteController {
    @Autowired
    private FileService fileService;

    @GetMapping(value = "/delete")
    public String delete(@RequestParam(name = "path", required = false, defaultValue = "D:\\") String path, Model model){
        int b = 9;
        System.out.println("мы в делите");
        return "test";
    }
}
