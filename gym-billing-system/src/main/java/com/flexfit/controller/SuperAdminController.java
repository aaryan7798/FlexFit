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
@RequestMapping("/superadmin")
public class SuperAdminController {

    @Autowired
    private GymOwnerService gymOwnerService;

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        List<GymOwner> gyms = gymOwnerService.getAllOwners();
        model.addAttribute("gyms", gyms);
        return "superadmin/dashboard";
    }

    @GetMapping("/gymowner/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        GymOwner gymOwner = gymOwnerService.getOwnerById(id);
        model.addAttribute("gymOwner", gymOwner);
        return "superadmin/gymowner-edit";
    }

    @PostMapping("/gymowner/edit/{id}")
    public String updateGymOwner(@PathVariable Long id,
                                 @ModelAttribute("gymOwner") GymOwner updatedOwner,
                                 @RequestParam(value = "gymPhotos", required = false) MultipartFile[] gymPhotos,
                                 @RequestParam(value = "trainerPhotos", required = false) MultipartFile[] trainerPhotos) throws IOException {

        List<String> gymPhotoFilenames = savePhotos(gymPhotos);
        List<String> trainerPhotoFilenames = savePhotos(trainerPhotos);

        if (!gymPhotoFilenames.isEmpty()) {
            updatedOwner.setGymPhotos(String.join(",", gymPhotoFilenames));
        }
        if (!trainerPhotoFilenames.isEmpty()) {
            updatedOwner.setTrainerPhotos(String.join(",", trainerPhotoFilenames));
        }
        gymOwnerService.updateOwner(id, updatedOwner);
        return "redirect:/superadmin/dashboard";
    }

    @PostMapping("/gymowner/delete/{id}")
    public String deleteGymOwner(@PathVariable Long id) {
        gymOwnerService.deleteOwner(id);
        return "redirect:/superadmin/dashboard";
    }

    @PostMapping("/gymowner/deactivate/{id}")
    public String deactivateGymOwner(@PathVariable Long id) {
        gymOwnerService.deactivateOwner(id);
        return "redirect:/superadmin/dashboard";
    }

    private List<String> savePhotos(MultipartFile[] photos) throws IOException {
        List<String> filenames = new ArrayList<>();
        String uploadDir = "uploads/";
        if (photos != null) {
            for (MultipartFile photo : photos) {
                if (!photo.isEmpty()) {
                    String uniqueFilename = UUID.randomUUID() + "_" + photo.getOriginalFilename();
                    File file = new File(uploadDir + uniqueFilename);
                    file.getParentFile().mkdirs();
                    photo.transferTo(file);
                    filenames.add(uniqueFilename);
                }
            }
        }
        return filenames;
    }
}
