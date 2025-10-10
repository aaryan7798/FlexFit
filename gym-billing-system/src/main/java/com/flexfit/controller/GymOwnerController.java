package com.flexfit.controller;

import com.flexfit.model.GymOwner;
import com.flexfit.service.GymOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class GymOwnerController {
    @Autowired
    private GymOwnerService gymOwnerService;

    @GetMapping("/gymowner/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("gymOwner", new GymOwner());
        return "gymowner-register";
    }

    @PostMapping("/gymowner/register")
    public String registerGymOwner(@ModelAttribute GymOwner gymOwner,
                                   @RequestParam("gymPhotos") MultipartFile[] gymPhotos,
                                   @RequestParam("trainerPhotos") MultipartFile[] trainerPhotos) throws IOException {
        gymOwner.setGymPhotos(String.join(",", savePhotos(gymPhotos)));
        gymOwner.setTrainerPhotos(String.join(",", savePhotos(trainerPhotos)));
        gymOwnerService.registerGymOwner(gymOwner);
        return "redirect:/login";
    }

    private List<String> savePhotos(MultipartFile[] photos) throws IOException {
        List<String> filenames = new ArrayList<>();
        String uploadDir = "uploads/";
        for (MultipartFile photo : photos) {
            if (!photo.isEmpty()) {
                String uniqueFilename = UUID.randomUUID() + "_" + photo.getOriginalFilename();
                File file = new File(uploadDir + uniqueFilename);
                file.getParentFile().mkdirs();
                photo.transferTo(file);
                filenames.add(uniqueFilename);
            }
        }
        return filenames;
    }
}
