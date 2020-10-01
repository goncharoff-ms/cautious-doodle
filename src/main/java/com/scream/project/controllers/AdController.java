package com.scream.project.controllers;

import com.scream.project.models.Ad;
import com.scream.project.repositories.AdRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class AdController {
    @Autowired
    private AdRepo adRepo;
    @GetMapping("/add")
    public String add(){
        return "ad_add";
    }

    @PostMapping("/add")
    public String adAdd(@RequestParam String title, @RequestParam String descriptions, @RequestParam String category, @RequestParam long numberPhone, LocalDateTime date){
        adRepo.save(new Ad(title,descriptions,category,numberPhone,date.now()));
        return "redirect:/";
    }
    @GetMapping("/{id}")
    public String adWithId(@PathVariable(value = "id") Long id, Model model){
        Optional<Ad> ad = adRepo.findById(id);
        List<Ad> adList = new ArrayList();
        ad.ifPresent(adList::add);
        model.addAttribute("ad", adList);
        return "ad_details";
    }


}
