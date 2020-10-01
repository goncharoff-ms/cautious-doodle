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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


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
  @PostMapping("searchText")
  public String search(Model model, @RequestParam  String searchText){
      Optional<Ad> ad = adRepo.findByTitle(searchText);
      List<Ad> adList = new ArrayList();
      ad.ifPresent(adList::add);
      model.addAttribute("ad", adList);
      return "ad";
  }
}

