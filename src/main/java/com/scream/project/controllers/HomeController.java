package com.scream.project.controllers;

import com.scream.project.models.Ad;
import com.scream.project.repositories.AdRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @Autowired
    private AdRepo adRepo;
    @GetMapping("/")
    public String adMain(Model model) {
        Iterable<Ad> ad = adRepo.findAll();
        model.addAttribute("ad", ad);
        return "ad";
    }
}

